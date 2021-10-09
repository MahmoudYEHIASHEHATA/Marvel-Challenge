package com.extreme.marvelchallenge.presentation.ui.home

import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.data.apiService.Status
import com.extreme.marvelchallenge.databinding.FragmentHomeBinding
import com.extreme.marvelchallenge.presentation.core.BaseFragment
import com.extreme.marvelchallenge.presentation.ui.home.adapter.CharactersCellAdapter
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
   lateinit var adapter: CharactersCellAdapter
    override fun init() {
        super.init()
        observeCharactersApi()
        setupCharactersCellAdapter()
    }

    private fun setupCharactersCellAdapter() {
         adapter = CharactersCellAdapter {

        }
        binding.recyclerCharacters.adapter = adapter
    }

    private fun observeCharactersApi() {
        viewModel.characterApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let {
                when (Resource.status) {
                    Status.ERROR -> {

                    }
                    Status.LOADING -> {

                    }
                    Status.SUCCESS -> {

                    }
                }
            }
        })
    }
}
