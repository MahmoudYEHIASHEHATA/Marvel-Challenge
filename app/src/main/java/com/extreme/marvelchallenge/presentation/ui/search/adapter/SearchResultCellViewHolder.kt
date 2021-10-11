package com.extreme.marvelchallenge.presentation.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.databinding.ItemSearchBinding


/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 10:54 PM
 */
class SearchResultCellViewHolder(
    private val binding: ItemSearchBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CharacterItem, searchText: String) {
        binding.item = item
        binding.searchText = searchText
        binding.executePendingBindings()
    }

    companion object {
        fun from(
            parent: ViewGroup
        ): SearchResultCellViewHolder {
            return SearchResultCellViewHolder(
                ItemSearchBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }
}
