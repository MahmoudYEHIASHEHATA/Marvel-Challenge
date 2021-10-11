package com.extreme.marvelchallenge.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.extreme.marvelchallenge.data.apiService.Resource
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity
import com.extreme.marvelchallenge.data.local.LocalData
import com.extreme.marvelchallenge.data.mappers.CharactersMapper
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsResponse
import com.extreme.marvelchallenge.data.models.network.events.EventsResponse
import com.extreme.marvelchallenge.data.models.network.series.SeriesResponse
import com.extreme.marvelchallenge.data.models.network.stories.StoriesResponse
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
    private val localData: LocalData,
    private val coroutineContext: CoroutineContext,
    private val mapper: dagger.Lazy<CharactersMapper>
) : DataRepositorySource {

    override suspend fun allCharactersApi(offset: Int): Resource<CharactersResponse> {
        return withContext(coroutineContext) {
            val resource = remoteData.getAllCharacters(offset)
            resource.data?.let {
                localData.addCharacter(it.charactersModels.map { character ->
                    mapper.get().toCharacterCache(character)
                })
            }
            return@withContext resource
        }
    }

    override fun allCharacters(): LiveData<List<CharacterItem>> {
        return localData.getAllCharacter().map {
            it.map { character ->
                mapper.get().toCharacterPresentable(character)
            }
        }
    }

    override suspend fun getCharacter(characterId: Int): CharacterCacheEntity {
        return withContext(coroutineContext) {
            localData.getCharacter(characterId)
        }
    }

    override suspend fun search(name: String): Resource<CharactersResponse> {
        return withContext(coroutineContext) {
            remoteData.searchOnCharacter(name)
        }
    }

    override suspend fun allComics(characterId: Int): Resource<ComicsResponse> {
        return withContext(coroutineContext) {
            remoteData.getComics(characterId)
        }
    }

    override suspend fun allEvents(characterId: Int): Resource<EventsResponse> {
        return withContext(coroutineContext) {
            remoteData.getEvents(characterId)
        }
    }

    override suspend fun allSeries(characterId: Int): Resource<SeriesResponse> {
        return withContext(coroutineContext) {
            remoteData.getSeries(characterId)
        }
    }

    override suspend fun allStories(characterId: Int): Resource<StoriesResponse> {
        return withContext(coroutineContext) {
            remoteData.getStories(characterId)
        }
    }


}
