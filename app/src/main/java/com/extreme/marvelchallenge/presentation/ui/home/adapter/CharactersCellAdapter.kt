package com.extreme.marvelchallenge.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.extreme.marvelchallenge.databinding.ItemCharacterBinding
import com.extreme.marvelchallenge.domain.model.CharacterItem
import com.extreme.marvelchallenge.presentation.core.BaseAdapter

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 5:59 PM
 */
class CharactersCellAdapter(private val callBack: (CharacterItem) -> Unit) :
    BaseAdapter<CharacterItem>(
        characterDiffCallback
    ) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val viewModel = CharacterItemViewModel()
        mBinding.viewModel = viewModel

        mBinding.rootView.setOnClickListener {
            mBinding.viewModel?.item?.get()?.let {
                callBack.invoke(it)
            }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        binding.executePendingBindings()
    }
}

val characterDiffCallback = object : DiffUtil.ItemCallback<CharacterItem>() {
    override fun areContentsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean =
        oldItem.id == newItem.id
}




