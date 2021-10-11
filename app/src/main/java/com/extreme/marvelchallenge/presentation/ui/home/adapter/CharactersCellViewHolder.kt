package com.extreme.marvelchallenge.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.databinding.ItemCharacterBinding

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 10:54 PM
 */
class CharactersCellViewHolder(
    private val binding: ItemCharacterBinding,
    private val callback: (CharacterItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CharacterItem) {
        binding.item = item
        binding.executePendingBindings()

        binding.root.setOnClickListener {
            callback.invoke(item)
        }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            callback: (CharacterItem) -> Unit
        ): CharactersCellViewHolder {
            return CharactersCellViewHolder(
                ItemCharacterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                callback
            )
        }
    }
}
