package com.extreme.marvelchallenge.data.remote

import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsResponse
import com.extreme.marvelchallenge.data.models.network.events.EventsResponse
import com.extreme.marvelchallenge.data.models.network.series.SeriesResponse
import com.extreme.marvelchallenge.data.models.network.stories.StoriesResponse

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:35 PM
 */
interface RemoteDataSource {

    suspend fun getAllCharacters(offset: Int): Resource<CharactersResponse>
    suspend fun searchOnCharacter(name: String): Resource<CharactersResponse>
    suspend fun getComics(characterId: Int): Resource<ComicsResponse>
    suspend fun getEvents(characterId: Int): Resource<EventsResponse>
    suspend fun getSeries(characterId: Int): Resource<SeriesResponse>
    suspend fun getStories(characterId: Int): Resource<StoriesResponse>
}
