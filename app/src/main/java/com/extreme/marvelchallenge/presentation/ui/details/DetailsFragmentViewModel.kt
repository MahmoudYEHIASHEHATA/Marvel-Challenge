package com.extreme.marvelchallenge.presentation.ui.details

import android.util.Log
import androidx.lifecycle.*
import com.extreme.marvelchallenge.data.DataRepository
import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity
import com.extreme.marvelchallenge.data.mappers.CharactersMapper
import com.extreme.marvelchallenge.data.models.domain.DetailCharacterItem
import com.extreme.marvelchallenge.data.models.network.comics.ComicsResponse
import com.extreme.marvelchallenge.data.models.network.events.EventsResponse
import com.extreme.marvelchallenge.data.models.network.series.SeriesResponse
import com.extreme.marvelchallenge.data.models.network.stories.StoriesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 10/10/2021 at 7:52 AM
 */
@HiltViewModel
class DetailsFragmentViewModel @Inject constructor(
    private val repository: DataRepository,
    private val mapper: dagger.Lazy<CharactersMapper>
) : ViewModel() {

    val characterId = MutableLiveData<Int?>()
    val characterRequestLiveData = MutableLiveData<CharacterCacheEntity>()

    val comicsApiWrapper = MutableLiveData<Resource<ComicsResponse>>()
    val seriesApiWrapper = MutableLiveData<Resource<SeriesResponse>>()
    val storiesApiWrapper = MutableLiveData<Resource<StoriesResponse>>()
    val eventsApiWrapper = MutableLiveData<Resource<EventsResponse>>()

    val comicsRequestLiveData: LiveData<ArrayList<DetailCharacterItem>> =
        Transformations.map(comicsApiWrapper) { comicApiResponse ->
            comicApiResponse.data?.comicsApiModels?.map { comic ->
                mapper.get().toComicPresentable(comic)
            } as ArrayList<DetailCharacterItem>?
        }

    val seriesRequestLiveData: LiveData<ArrayList<DetailCharacterItem>> =
        Transformations.map(seriesApiWrapper) { seriesApiResponse ->
            seriesApiResponse.data?.seriesApiModels?.map { series ->
                mapper.get().toSeriesPresentable(series)
            } as ArrayList<DetailCharacterItem>?
        }

    val storiesRequestLiveData: LiveData<ArrayList<DetailCharacterItem>> =
        Transformations.map(storiesApiWrapper) { storiesApiResponse ->
            storiesApiResponse.data?.storiesApiModels?.map { story ->
                mapper.get().toStoriesPresentable(story)
            } as ArrayList<DetailCharacterItem>?
        }

    val eventsRequestLiveData: LiveData<ArrayList<DetailCharacterItem>> =
        Transformations.map(eventsApiWrapper) { eventApiResponse ->
            eventApiResponse.data?.eventsApiModels?.map { event ->
                mapper.get().toEventsPresentable(event)
            } as ArrayList<DetailCharacterItem>?
        }

    private fun getCharacterData() {
        viewModelScope.launch {
            characterRequestLiveData.value =
                characterId.value?.let { repository.getCharacter(it) }
        }
        Log.e("characterRequestLiveData", characterRequestLiveData.value.toString())
        Log.e("characterRequestLiveData", characterId.value.toString())

    }

    private fun getComics() {
        viewModelScope.launch {
            comicsApiWrapper.value = Resource.Loading()
            val comicsResource = characterId.value?.let { repository.allComics(it) }
            comicsResource?.let { comicsApiWrapper.value = it }
        }
    }

    private fun getSeries() {
        viewModelScope.launch {
            seriesApiWrapper.value = Resource.Loading()
            val seriesResource = characterId.value?.let { repository.allSeries(it) }
            seriesResource?.let { seriesApiWrapper.value = it }
        }
    }

    private fun getStories() {
        viewModelScope.launch {
            storiesApiWrapper.value = Resource.Loading()
            val storiesResource = characterId.value?.let { repository.allStories(it) }
            storiesResource?.let { storiesApiWrapper.value = it }
        }
    }

    private fun getEvents() {
        viewModelScope.launch {
            eventsApiWrapper.value = Resource.Loading()
            val eventsResource = characterId.value?.let { repository.allEvents(it) }
            eventsResource?.let { eventsApiWrapper.value = it }
        }
    }

    fun callDetailCharacterItems() {
        getCharacterData()
        getComics()
        getSeries()
        getStories()
        getEvents()
    }
}
