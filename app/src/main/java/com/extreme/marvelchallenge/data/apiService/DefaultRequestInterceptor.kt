package com.extreme.marvelchallenge.data.apiService

import com.extreme.marvelchallenge.presentation.core.Constants
import com.extreme.marvelchallenge.presentation.core.Constants.NetworkService
import com.extreme.marvelchallenge.presentation.core.Constants.NetworkService.API_KEY_NAME
import com.extreme.marvelchallenge.presentation.core.Constants.NetworkService.API_KEY_VALUE
import com.extreme.marvelchallenge.presentation.core.Constants.NetworkService.PRIVATE_KEY_VALUE
import com.extreme.marvelchallenge.presentation.util.md5
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 8:21 PM
 */
@Singleton
class DefaultRequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val ts =
            (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis
                    / Constants.StanderValues.TIME_ZONE_UNIT).toString()
        val url = chain.request().url
            .newBuilder()
            .addQueryParameter(
                NetworkService.API_TS_NAME,
                ts
            )
            .addQueryParameter(
                API_KEY_NAME,
                API_KEY_VALUE
            )
            .addQueryParameter(
                NetworkService.API_HASH_NAME,
                "$ts$PRIVATE_KEY_VALUE$API_KEY_VALUE".md5()
            )
            .build()
        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
