package com.extreme.marvelchallenge.presentation.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.extreme.marvelchallenge.data.models.domain.CharacterItem

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 5:59 PM
 */
class CharactersCellAdapter(private val callback: (CharacterItem) -> Unit) :
    ListAdapter<CharacterItem, CharactersCellViewHolder>(
        DiffUtilCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharactersCellViewHolder {
        return CharactersCellViewHolder.from(parent,callback)
    }

    override fun onBindViewHolder(holder: CharactersCellViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffUtilCallback : DiffUtil.ItemCallback<CharacterItem>() {
        override fun areItemsTheSame(
            oldItem: CharacterItem,
            newItem: CharacterItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterItem,
            newItem: CharacterItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}
