package com.extreme.marvelchallenge.presentation.ui.details

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.data.apiService.Error
import com.extreme.marvelchallenge.data.apiService.Status
import com.extreme.marvelchallenge.databinding.FragmentDetailsBinding
import com.extreme.marvelchallenge.presentation.core.BaseFragment
import com.extreme.marvelchallenge.presentation.ui.details.adapter.ComicsCellAdapter
import com.extreme.marvelchallenge.presentation.ui.details.adapter.EventsCellAdapter
import com.extreme.marvelchallenge.presentation.ui.details.adapter.SeriesCellAdapter
import com.extreme.marvelchallenge.presentation.ui.details.adapter.StoriesCellAdapter
import com.extreme.marvelchallenge.presentation.util.hide
import com.extreme.marvelchallenge.presentation.util.show
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Mahmoud Shehatah
 * Created 10/10/2021 at 7:49 AM
 */
@AndroidEntryPoint
class DetailsFragment : BaseFragment<DetailsFragmentViewModel, FragmentDetailsBinding>(
    R.layout.fragment_details,
    DetailsFragmentViewModel::class.java,
) {

    private val characterDetailsFragmentArgs: DetailsFragmentArgs by navArgs()

    override fun init() {
        super.init()
        viewModel.characterId.value = characterDetailsFragmentArgs.characterId
        viewModel.callDetailCharacterItems()
        startObserversApi()
        setupAdapters()
        binding.backIv.setOnClickListener {
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

    private fun setupComicsCellAdapter() {
        val adapter = ComicsCellAdapter {

        }
        binding.recyclerComics.adapter = adapter
    }

    private fun setupSeriesCellAdapter() {
        val adapter = SeriesCellAdapter {

        }
        binding.recyclerSeries.adapter = adapter
    }

    private fun setupStoriesCellAdapter() {
        val adapter = StoriesCellAdapter {

        }
        binding.recyclerStories.adapter = adapter
    }

    private fun setupCharactersCellAdapter() {
        val adapter = EventsCellAdapter {

        }
        binding.recyclerEvents.adapter = adapter
    }

    private fun observeComicsApi() {
        viewModel.comicsApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let {
                when (Resource.status) {
                    Status.ERROR -> {
                        handleError(Resource.error)
                        binding.progressBarComics.hide()
                    }
                    Status.LOADING -> {
                        binding.progressBarComics.show()
                    }
                    Status.SUCCESS -> {
                        binding.progressBarComics.hide()
                    }
                    Status.COMPLETE -> binding.progressBarComics.hide()
                }
            }
        })
    }

    private fun observeSeriesApi() {
        viewModel.seriesApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let {
                when (Resource.status) {
                    Status.ERROR -> {
                        handleError(Resource.error)
                        binding.progressBarSeries.hide()
                    }
                    Status.LOADING -> {
                        binding.progressBarSeries.show()

                    }
                    Status.SUCCESS -> {
                        binding.progressBarSeries.hide()
                    }
                    Status.COMPLETE -> binding.progressBarSeries.hide()
                }
            }
        })
    }

    private fun observeStoriesApi() {
        viewModel.storiesApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let {
                when (Resource.status) {
                    Status.ERROR -> {
                        handleError(Resource.error)
                        binding.progressBarStories.hide()
                    }
                    Status.LOADING -> {
                        binding.progressBarStories.show()
                    }
                    Status.SUCCESS -> {
                        binding.progressBarStories.hide()
                    }
                    Status.COMPLETE -> binding.progressBarStories.hide()
                }
            }
        })
    }

    private fun observeEventsApi() {
        viewModel.eventsApiWrapper.observe(viewLifecycleOwner, { Resource ->
            Resource?.let {
                when (Resource.status) {
                    Status.ERROR -> {
                        handleError(Resource.error)
                        binding.progressBarEvents.hide()
                    }
                    Status.LOADING -> {
                        binding.progressBarEvents.show()
                    }
                    Status.SUCCESS -> {
                        binding.progressBarEvents.hide()
                    }
                    Status.COMPLETE -> binding.progressBarEvents.hide()
                }
            }
        })
    }

    private fun startObserversApi() {
        observeComicsApi()
        observeSeriesApi()
        observeStoriesApi()
        observeEventsApi()
    }

    private fun setupAdapters() {
        setupComicsCellAdapter()
        setupSeriesCellAdapter()
        setupStoriesCellAdapter()
        setupCharactersCellAdapter()
    }
}
