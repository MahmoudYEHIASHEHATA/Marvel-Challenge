package com.extreme.marvelchallenge.presentation.ui.home

import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.databinding.FragmentHomeBinding
import com.extreme.marvelchallenge.presentation.core.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 10:48 AM
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeFragmentViewModel::class.java,
) {
    override fun init() {
        super.init()
    }
}