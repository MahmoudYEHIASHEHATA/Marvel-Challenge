package com.extreme.marvelchallenge.data.local

import androidx.lifecycle.LiveData
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 7:55 PM
 */
interface LocalDataSource {
    fun getAllCharacter(): LiveData<List<CharacterCacheEntity>>
    suspend fun getCharacter(characterId: Int): CharacterCacheEntity
    suspend fun addCharacter(characters: List<CharacterCacheEntity>)
}