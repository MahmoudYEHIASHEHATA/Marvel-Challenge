package com.extreme.marvelchallenge.presentation.core

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 6:05 PM
 */
open class BaseViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(
    binding.root
)
