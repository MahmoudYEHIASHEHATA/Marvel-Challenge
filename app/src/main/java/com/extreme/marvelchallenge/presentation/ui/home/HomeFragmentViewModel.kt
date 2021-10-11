package com.extreme.marvelchallenge.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.extreme.marvelchallenge.data.DataRepository
import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.presentation.core.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 10:49 AM
 */
@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {

    var lastOffset = Constants.NetworkService.FIRST_PAGE
    var total: Int = Constants.NetworkService.START_TOTAL

    val characterApiWrapper = MutableLiveData<Resource<CharactersResponse>>()

    init {
        getCharacter()
    }

    val charactersRequestLiveData: LiveData<List<CharacterItem>> = repository.allCharacters()

    fun getCharacter() {
        viewModelScope.launch {
            characterApiWrapper.value = Resource.Loading()
            val charactersResource = repository.allCharactersApi(lastOffset)
            characterApiWrapper.value = charactersResource
            Log.d(" charactersResource", charactersResource.toString())
        }
    }
}
