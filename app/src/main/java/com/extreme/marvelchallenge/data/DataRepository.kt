package com.extreme.marvelchallenge.data

import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.mappers.CharactersMapper
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsModel
import com.extreme.marvelchallenge.data.models.network.events.EventsModel
import com.extreme.marvelchallenge.data.models.network.series.SeriesModel
import com.extreme.marvelchallenge.data.models.network.stories.StoriesModel
import com.extreme.marvelchallenge.data.remote.RemoteData
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 12:42 AM
 */
class DataRepository @Inject constructor(
    private val remoteData: RemoteData,
    private val coroutineContext: CoroutineContext,
) : DataRepositorySource {

    override suspend fun allCharacters(offset: Int): Resource<CharactersResponse> {
        return withContext(coroutineContext) {
            remoteData.getAllCharacters(offset)
        }
    }

    override suspend fun search(name: String): Resource<CharactersResponse> {
        return withContext(coroutineContext) {
            remoteData.searchOnCharacter(name)
        }
    }

    override suspend fun allComics(characterId: Int): Resource<ComicsModel> {
        return withContext(coroutineContext) {
            remoteData.getComics(characterId)
        }
    }

    override suspend fun allEvents(characterId: Int): Resource<EventsModel> {
        return withContext(coroutineContext) {
            remoteData.getEvents(characterId)
        }
    }

    override suspend fun allSeries(characterId: Int): Resource<SeriesModel> {
        return withContext(coroutineContext) {
            remoteData.getSeries(characterId)
        }
    }

    override suspend fun allStories(characterId: Int): Resource<StoriesModel> {
        return withContext(coroutineContext) {
            remoteData.getStories(characterId)
        }
    }
}
