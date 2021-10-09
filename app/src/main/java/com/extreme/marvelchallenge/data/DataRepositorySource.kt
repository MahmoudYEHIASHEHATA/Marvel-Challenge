package com.extreme.marvelchallenge.data

import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsModel
import com.extreme.marvelchallenge.data.models.network.events.EventsModel
import com.extreme.marvelchallenge.data.models.network.series.SeriesModel
import com.extreme.marvelchallenge.data.models.network.stories.StoriesModel

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 12:45 AM
 */
interface DataRepositorySource {
    suspend fun allCharacters(offset: Int): Resource<CharactersResponse>
    suspend fun search(name: String): Resource<CharactersResponse>
    suspend fun allComics(characterId: Int): Resource<ComicsModel>
    suspend fun allEvents(characterId: Int): Resource<EventsModel>
    suspend fun allSeries(characterId: Int): Resource<SeriesModel>
    suspend fun allStories(characterId: Int): Resource<StoriesModel>
}
