package com.extreme.marvelchallenge.data.remote

import android.content.Context
import android.util.Log
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.data.apiService.*
import com.extreme.marvelchallenge.data.models.GeneralApiResponse
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsResponse
import com.extreme.marvelchallenge.data.models.network.events.EventsResponse
import com.extreme.marvelchallenge.data.models.network.series.SeriesResponse
import com.extreme.marvelchallenge.data.models.network.stories.StoriesResponse
import com.extreme.marvelchallenge.data.shared.AppNetworkManager
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:30 PM
 */
class RemoteData @Inject constructor(
    private val apiService: ApiService,
    private val appNetworkManager: AppNetworkManager,
    @ApplicationContext private val context: Context
) : RemoteDataSource {

    override suspend fun getAllCharacters(offset: Int): Resource<CharactersResponse> {
        return processCall { apiService.allCharacters(offset) }
    }

    override suspend fun searchOnCharacter(
        name: String
    ): Resource<CharactersResponse> {
        return processCall { apiService.searchOnCharacter(name) }
    }

    override suspend fun getComics(characterId: Int): Resource<ComicsResponse> {
        return processCall { apiService.getComics(characterId) }
    }

    override suspend fun getEvents(characterId: Int): Resource<EventsResponse> {
        return processCall { apiService.getEvents(characterId) }
    }

    override suspend fun getSeries(characterId: Int): Resource<SeriesResponse> {
        return processCall { apiService.getSeries(characterId) }
    }

    override suspend fun getStories(characterId: Int): Resource<StoriesResponse> {
        return processCall { apiService.getStories(characterId) }
    }

    private suspend fun <T> processCall(requestCall: suspend () -> Response<GeneralApiResponse<T>>): Resource<T> {

        if (!appNetworkManager.isConnected()) {

            return Resource.Failure(
                Error(
                    code = ResponseCode.NETWORK_NOT_AVAILABLE.value,
                    message = context.getString(R.string.no_network)
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
                    val error = try {
                        val errorResponse = Gson().fromJson(
                            response.errorBody()?.charStream(),
                            GeneralErrorResponse::class.java
                        )
                        errorResponse.message?.let { Log.d("message", it) }
                        Error(code = response.code(), message = errorResponse.message)
                    } catch (e: RuntimeException) {
                        Error(code = response.code())
                    }

                    return Resource.Failure(error)
                }
            }
        } catch (t: Throwable) {
            Resource.Failure(
                Error(
                    code = ResponseCode.NETWORK_ERROR.value,
                    message = t.message.toString()
                )
            )
        }
    }
}
