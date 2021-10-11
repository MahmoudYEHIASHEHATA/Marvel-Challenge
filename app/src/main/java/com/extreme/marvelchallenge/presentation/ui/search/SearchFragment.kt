package com.extreme.marvelchallenge.presentation.ui.search

import androidx.navigation.fragment.findNavController
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.data.apiService.Error
import com.extreme.marvelchallenge.data.apiService.Status
import com.extreme.marvelchallenge.databinding.FragmentSearchBinding
import com.extreme.marvelchallenge.presentation.core.BaseFragment
import com.extreme.marvelchallenge.presentation.ui.search.adapter.SearchResultCellAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 3:08 PM
 */
@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchFragmentViewModel, FragmentSearchBinding>(
    R.layout.fragment_search,
    SearchFragmentViewModel::class.java,
) {

    override fun init() {
        super.init()
        observeCharactersApi()
        setupCharactersCellAdapter()
        observeSearchQuery()
        binding.searchIv.setOnClickListener {
            viewModel.search()
        }
        binding.cancelBt.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun handleError(error: Error?) {
        error?.let {
            it.message?.let { message ->
                Snackbar.make(
                    requireView(),
                    message, Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun hideLoading() {
        binding.isLoading = false
    }

    private fun showLoading() {
        binding.isLoading = true
    }

    private fun setupCharactersCellAdapter() {
        val adapter = SearchResultCellAdapter()
        binding.recyclerCharacters.adapter = adapter
    }

    private fun observeSearchQuery() {
        viewModel.searchTextLivData.observe(viewLifecycleOwner, {
            (binding.recyclerCharacters.adapter as SearchResultCellAdapter).setSearch(it)
            viewModel.search()
        })
    }

    private fun observeCharactersApi() {
        viewModel.characterApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let {
                when (Resource.status) {
                    Status.ERROR -> {
                        hideLoading()
                        handleError(Resource.error)
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                    Status.SUCCESS -> {
                        hideLoading()
                        viewModel.previousSearchText = viewModel.searchTextLivData.value
                    }
                    Status.COMPLETE -> hideLoading()
                }
            }
        })
    }
}
