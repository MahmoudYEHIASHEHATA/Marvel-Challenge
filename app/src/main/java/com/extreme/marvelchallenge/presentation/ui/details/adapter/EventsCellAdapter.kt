package com.extreme.marvelchallenge.presentation.ui.details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.extreme.marvelchallenge.data.models.domain.DetailCharacterItem

/**
 * @author Mahmoud Shehatah
 * Created 10/10/2021 at 8:00 AM
 */
class EventsCellAdapter(private val callback: (DetailCharacterItem) -> Unit) :
    ListAdapter<DetailCharacterItem, EventsCellViewHolder>(
        DiffUtilCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventsCellViewHolder {
        return EventsCellViewHolder.from(parent, callback)
    }

    override fun onBindViewHolder(holder: EventsCellViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffUtilCallback : DiffUtil.ItemCallback<DetailCharacterItem>() {
        override fun areItemsTheSame(
            oldItem: DetailCharacterItem,
            newItem: DetailCharacterItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DetailCharacterItem,
            newItem: DetailCharacterItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}
