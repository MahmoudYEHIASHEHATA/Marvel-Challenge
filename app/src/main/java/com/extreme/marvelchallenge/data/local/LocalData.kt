package com.extreme.marvelchallenge.data.local

import androidx.lifecycle.LiveData
import com.extreme.marvelchallenge.data.db.dao.CharacterDao
import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 7:29 PM
 */
class LocalData @Inject constructor(private val characterDao: CharacterDao) : LocalDataSource {
    override fun getAllCharacter(): LiveData<List<CharacterCacheEntity>> {
        return characterDao.getCharacter()
    }

    override suspend fun getCharacter(characterId: Int): CharacterCacheEntity {
        return characterDao.loadSingleCharacter(characterId)
    }

    override suspend fun addCharacter(characters: List<CharacterCacheEntity>) {
        characterDao.addCharacter(characters)
    }
}
