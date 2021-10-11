package com.extreme.marvelchallenge.data.apiService

import com.extreme.marvelchallenge.data.models.GeneralApiResponse
import com.extreme.marvelchallenge.data.models.network.character.CharactersResponse
import com.extreme.marvelchallenge.data.models.network.comics.ComicsResponse
import com.extreme.marvelchallenge.data.models.network.events.EventsResponse
import com.extreme.marvelchallenge.data.models.network.series.SeriesResponse
import com.extreme.marvelchallenge.data.models.network.stories.StoriesResponse
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
    suspend fun searchOnCharacter(@Query("nameStartsWith") name: String? = null)
            : Response<GeneralApiResponse<CharactersResponse>>

    @GET("characters/{characterId}/comics")
    suspend fun getComics(@Path("characterId") characterId: Int): Response<GeneralApiResponse<ComicsResponse>>

    @GET("characters/{characterId}/events")
    suspend fun getEvents(@Path("characterId") characterId: Int): Response<GeneralApiResponse<EventsResponse>>

    @GET("characters/{characterId}/stories")
    suspend fun getStories(@Path("characterId") characterId: Int): Response<GeneralApiResponse<StoriesResponse>>

    @GET("characters/{characterId}/series")
    suspend fun getSeries(@Path("characterId") characterId: Int): Response<GeneralApiResponse<SeriesResponse>>
}
