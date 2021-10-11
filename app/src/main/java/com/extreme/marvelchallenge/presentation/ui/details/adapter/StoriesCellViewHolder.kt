package com.extreme.marvelchallenge.presentation.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.extreme.marvelchallenge.data.models.domain.DetailCharacterItem
import com.extreme.marvelchallenge.databinding.ItemCharacterDetailsBinding

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 10:54 PM
 */
class StoriesCellViewHolder(
    private val binding: ItemCharacterDetailsBinding,
    private val callback: (DetailCharacterItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DetailCharacterItem) {
        binding.title = item.title
        binding.imagePath = item.thumbnail?.path
        binding.extension = item.thumbnail?.extension
        binding.executePendingBindings()

        binding.root.setOnClickListener {
            callback.invoke(item)
        }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            callback: (DetailCharacterItem) -> Unit
        ): StoriesCellViewHolder {
            return StoriesCellViewHolder(
                ItemCharacterDetailsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                callback
            )
        }
    }
}
