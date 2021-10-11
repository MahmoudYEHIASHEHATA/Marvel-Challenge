package com.extreme.marvelchallenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.extreme.marvelchallenge.data.db.dao.CharacterDao
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 7:36 PM
 */
@Database(
    entities = [
        CharacterCacheEntity::class
    ],
    version = 1
)
abstract class MarvelDataBase : RoomDatabase() {

    abstract fun charactersDao(): CharacterDao
}
