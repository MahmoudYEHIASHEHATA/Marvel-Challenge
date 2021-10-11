package com.extreme.marvelchallenge.data

import androidx.lifecycle.LiveData
import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsResponse
import com.extreme.marvelchallenge.data.models.network.events.EventsResponse
import com.extreme.marvelchallenge.data.models.network.series.SeriesResponse
import com.extreme.marvelchallenge.data.models.network.stories.StoriesResponse

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 12:45 AM
 */
interface DataRepositorySource {
    suspend fun allCharactersApi(offset: Int): Resource<CharactersResponse>
    fun allCharacters(): LiveData<List<CharacterItem>>
    suspend fun getCharacter(characterId: Int): CharacterCacheEntity
    suspend fun search(name: String): Resource<CharactersResponse>
    suspend fun allComics(characterId: Int): Resource<ComicsResponse>
    suspend fun allEvents(characterId: Int): Resource<EventsResponse>
    suspend fun allSeries(characterId: Int): Resource<SeriesResponse>
    suspend fun allStories(characterId: Int): Resource<StoriesResponse>

}
