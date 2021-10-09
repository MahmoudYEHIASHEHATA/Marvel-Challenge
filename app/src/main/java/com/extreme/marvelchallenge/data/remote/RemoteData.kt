package com.extreme.marvelchallenge.data.remote

import com.extreme.marvelchallenge.data.apiService.*
import com.extreme.marvelchallenge.data.models.GeneralApiResponse
import com.extreme.marvelchallenge.data.shared.AppNetworkManager
import retrofit2.Response
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsModel
import com.extreme.marvelchallenge.data.models.network.events.EventsModel
import com.extreme.marvelchallenge.data.models.network.series.SeriesModel
import com.extreme.marvelchallenge.data.models.network.stories.StoriesModel
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:30 PM
 */
class RemoteData @Inject constructor(
    private val apiService: ApiService,
    private val appNetworkManager: AppNetworkManager,
) : RemoteDataSource {

    override suspend fun getAllCharacters(offset: Int): Resource<CharactersResponse> {
       return processCall { apiService.allCharacters(offset) }

    }

    override suspend fun searchOnCharacter(name: String): Resource<CharactersResponse> {
        return processCall { apiService.searchOnCharacter(name) }
    }

    override suspend fun getComics(characterId: Int): Resource<ComicsModel> {
        return processCall { apiService.getComics(characterId) }
    }

    override suspend fun getEvents(characterId: Int): Resource<EventsModel> {
        return processCall { apiService.getEvents(characterId) }
    }

    override suspend fun getSeries(characterId: Int): Resource<SeriesModel> {
        return processCall { apiService.getSeries(characterId) }
    }

    override suspend fun getStories(characterId: Int): Resource<StoriesModel> {
        return processCall { apiService.getStories(characterId) }
    }

    private suspend fun <T> processCall(requestCall: suspend () -> Response<GeneralApiResponse<T>>): Resource<T> {

        if (!appNetworkManager.isConnected()) {

            return Resource.Failure(
                Error(
                    code = ResponseCode.NETWORK_NOT_AVAILABLE.value,
                    msg = null
                )

            )
        }


        return try {
            val response = requestCall.invoke()

            return when (response.code()) {
                ResponseCode.OK.value -> {
                    Resource.Success(response.body()!!.data)
                }
                else -> {
                    return Resource.Failure(
                        Error(
                            code = ResponseCode.NETWORK_NOT_AVAILABLE.value,
                            msg = null
                        )
                    )

                }
            }
        } catch (t: Throwable) {
            Resource.Failure(
                Error(
                    code = ResponseCode.NETWORK_ERROR.value,
                    msg = t.message.toString()
                )
            )
        }


    }
}
