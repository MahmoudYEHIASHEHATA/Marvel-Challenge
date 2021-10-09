package com.extreme.marvelchallenge.data.apiService

import com.extreme.marvelchallenge.data.models.GeneralApiResponse
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsModel
import com.extreme.marvelchallenge.data.models.network.events.EventsModel
import com.extreme.marvelchallenge.data.models.network.series.SeriesModel
import com.extreme.marvelchallenge.data.models.network.stories.StoriesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 8:14 PM
 */
interface ApiService {

    @GET("characters")
    suspend fun allCharacters(@Query("offset") offset: Int): Response<GeneralApiResponse<CharactersResponse>>

    @GET("characters")
    suspend fun searchOnCharacter(@Query("name") name: String? = null): Response<GeneralApiResponse<CharactersResponse>>

    @GET("characters/{characterId}/comics")
    suspend fun getComics(@Path("characterId") characterId: Int): Response<GeneralApiResponse<ComicsModel>>

    @GET("characters/{characterId}/events")
    suspend fun getEvents(@Path("characterId") characterId: Int): Response<GeneralApiResponse<EventsModel>>

    @GET("characters/{characterId}/stories")
    suspend fun getStories(@Path("characterId") characterId: Int): Response<GeneralApiResponse<StoriesModel>>

    @GET("characters/{characterId}/series")
    suspend fun getSeries(@Path("characterId") characterId: Int): Response<GeneralApiResponse<SeriesModel>>
}