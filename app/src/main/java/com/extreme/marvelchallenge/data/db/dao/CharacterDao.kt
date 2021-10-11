package com.extreme.marvelchallenge.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 7:39 PM
 */
@Dao
interface CharacterDao {

    @Query("select * from Character")
    fun getCharacter(): LiveData<List<CharacterCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(characters: List<CharacterCacheEntity>)

    @Query("SELECT * FROM Character WHERE id=:id ")
    fun loadSingleCharacter(id: Int): CharacterCacheEntity
}