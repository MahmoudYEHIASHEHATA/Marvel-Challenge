package com.extreme.marvelchallenge.data.remote

import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsModel
import com.extreme.marvelchallenge.data.models.network.events.EventsModel
import com.extreme.marvelchallenge.data.models.network.series.SeriesModel
import com.extreme.marvelchallenge.data.models.network.stories.StoriesModel

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:35 PM
 */
interface RemoteDataSource {

    suspend fun getAllCharacters(offset: Int): Resource<CharactersResponse>
    suspend fun searchOnCharacter(name: String): Resource<CharactersResponse>
    suspend fun getComics(characterId: Int): Resource<ComicsModel>
    suspend fun getEvents(characterId: Int): Resource<EventsModel>
    suspend fun getSeries(characterId: Int): Resource<SeriesModel>
    suspend fun getStories(characterId: Int): Resource<StoriesModel>
}
