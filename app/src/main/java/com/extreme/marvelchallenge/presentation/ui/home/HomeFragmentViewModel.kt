package com.extreme.marvelchallenge.presentation.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.extreme.marvelchallenge.data.DataRepository
import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.mappers.CharactersMapper
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 10:49 AM
 */
@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val repository: DataRepository, private val mapper: dagger.Lazy<CharactersMapper>
) : ViewModel() {


    var finalOffset = 0
    val characterApiWrapper = MutableLiveData<Resource<CharactersResponse>>()

    init {
        getCharacter()
    }

    val charactersRequestLiveData: LiveData<ArrayList<CharacterItem>> =
        Transformations.map(characterApiWrapper) {
            it.data?.charactersModels?.map { character ->
                mapper.get().toCharacterPresentable(character)
            } as ArrayList<CharacterItem>?
        }

    private fun getCharacter() {
        viewModelScope.launch {
            characterApiWrapper.value = Resource.Loading()
            val charactersResource = repository.allCharacters(finalOffset)
            characterApiWrapper.value = charactersResource
            Log.d(" charactersResource", charactersResource.toString())
        }
    }
}
