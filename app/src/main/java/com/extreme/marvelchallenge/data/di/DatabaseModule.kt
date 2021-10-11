package com.extreme.marvelchallenge.data.di

import android.content.Context
import androidx.room.Room
import com.extreme.marvelchallenge.data.db.MarvelDataBase
import com.extreme.marvelchallenge.data.db.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 7:35 PM
 */
@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MarvelDataBase =
        Room.databaseBuilder(
            context,
            MarvelDataBase::class.java,
            "Marvel-Database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideForecastDao(db: MarvelDataBase): CharacterDao = db.charactersDao()
}
