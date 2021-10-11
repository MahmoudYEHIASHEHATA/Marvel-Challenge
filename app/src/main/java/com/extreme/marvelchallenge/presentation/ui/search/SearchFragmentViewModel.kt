package com.extreme.marvelchallenge.presentation.ui.search

import androidx.lifecycle.*
import com.extreme.marvelchallenge.data.DataRepository
import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.mappers.CharactersMapper
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.presentation.core.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 3:09 PM
 */
@HiltViewModel
class SearchFragmentViewModel @Inject constructor(
    private val repository: DataRepository, private val mapper: dagger.Lazy<CharactersMapper>
) : ViewModel() {

    private var searchJob: Job? = null
    val searchTextLivData = MutableLiveData<String>()
    var previousSearchText: String? = null

    val characterApiWrapper = MutableLiveData<Resource<CharactersResponse>>()

    val charactersRequestLiveData: LiveData<ArrayList<CharacterItem>> =
        Transformations.map(characterApiWrapper) {
            it.data?.charactersModels?.map { character ->
                mapper.get().toCharacterPresentable(character)
            } as ArrayList<CharacterItem>?
        }

    fun search() {
        searchJob?.cancel() // cancel previous job when user enters new letter
        searchJob = viewModelScope.launch {
            searchTextLivData.value?.let {
                if (it != previousSearchText) {
                    delay(Constants.NetworkService.DELAY_TIME_FOR_SEARCH) // add some delay before search, this function checks if coroutine is canceled, if it is canceled it won't continue execution
                    characterApiWrapper.value = Resource.Loading()
                    val charactersResource = repository.search(it)
                    characterApiWrapper.value = charactersResource
                }
            }
        }
    }
}