package com.extreme.marvelchallenge.presentation.ui.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.extreme.marvelchallenge.data.models.domain.CharacterItem

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 5:59 PM
 */
class SearchResultCellAdapter :
    ListAdapter<CharacterItem, SearchResultCellViewHolder>(
        DiffUtilCallback
    ) {
    private var searchText = ""
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchResultCellViewHolder {
        return SearchResultCellViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SearchResultCellViewHolder, position: Int) {
        holder.bind(getItem(position), searchText)
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

    fun setSearch(name: String) {
        searchText = name
        notifyDataSetChanged()
    }
}
