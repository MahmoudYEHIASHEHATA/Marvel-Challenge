package com.extreme.marvelchallenge.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 12:02 AM
 */
abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    viewModelClass: Class<VM>
) : Fragment() {

    protected lateinit var binding: DB
        private set

    open fun init() {}

    protected val viewModel: VM by lazy {
        ViewModelProvider(this)[viewModelClass]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.run {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
        }
        init()
        return binding.root
    }

    open fun refresh() {}

    open fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }
}
