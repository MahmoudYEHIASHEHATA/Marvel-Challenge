package com.extreme.marvelchallenge.data.di

import android.os.Environment
import com.extreme.marvelchallenge.data.apiService.DefaultRequestInterceptor
import com.extreme.marvelchallenge.presentation.core.Constants.NetworkService.BASE_URL
import com.extreme.marvelchallenge.presentation.core.Constants.StanderValues.MAX_CASH_VALUE
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 9:07 PM
 */
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    @Singleton
    fun provideCache(): Cache =
        Cache(Environment.getDownloadCacheDirectory(), MAX_CASH_VALUE.toLong())

    @Provides
    @Singleton
    fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(logging: HttpLoggingInterceptor): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(DefaultRequestInterceptor())
            .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        okHttpClientBuilder: OkHttpClient.Builder,
        cache: Cache,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClientBuilder.cache(cache).build())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
