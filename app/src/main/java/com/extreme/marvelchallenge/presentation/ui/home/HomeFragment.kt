package com.extreme.marvelchallenge.presentation.ui.home

import android.widget.AbsListView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.data.apiService.Error
import com.extreme.marvelchallenge.data.apiService.Status
import com.extreme.marvelchallenge.databinding.FragmentHomeBinding
import com.extreme.marvelchallenge.presentation.core.BaseFragment
import com.extreme.marvelchallenge.presentation.ui.home.adapter.CharactersCellAdapter
import com.google.android.material.snackbar.Snackbar
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
        observeCharactersApi()
        setupCharactersCellAdapter()
        onScroll()
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
        val adapter = CharactersCellAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it.id)
            findNavController().navigate(action)
        }
        binding.recyclerCharacters.adapter = adapter
    }

    var loading = true
    private fun onScroll() {
        binding.recyclerCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    loading = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy >= 0) //check for scroll down
                {
                    val visibleItemCount: Int =
                        binding.recyclerCharacters.layoutManager!!.childCount
                    val totalItemCount: Int =
                        if (viewModel.charactersRequestLiveData.value?.size == null) 0 else viewModel.charactersRequestLiveData.value?.size!!
                    val pastVisibleItems: Int = totalItemCount - visibleItemCount
                    if (loading) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount
                            && viewModel.charactersRequestLiveData.value?.size!! <=
                            viewModel.total
                        ) {
                            viewModel.lastOffset = totalItemCount
                            viewModel.getCharacter()
                            loading = false
                        }
                    }
                }
            }
        })
    }

    private fun observeCharactersApi() {
        viewModel.characterApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let { it ->
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
                        it.data?.total?.let { totalItems ->
                            viewModel.total = totalItems
                        }
                    }
                    Status.COMPLETE -> hideLoading()
                }
            }
        })
    }
}
