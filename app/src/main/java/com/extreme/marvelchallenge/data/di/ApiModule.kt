package com.extreme.marvelchallenge.data.di

import com.extreme.marvelchallenge.data.apiService.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 9:15 PM
 */
@InstallIn(SingletonComponent::class)
@Module(includes = [NetworkModule::class])
object ApiModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
