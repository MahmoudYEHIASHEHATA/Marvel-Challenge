package com.extreme.marvelchallenge.data.models.cache

import com.extreme.marvelchallenge.data.models.network.character.Thumbnail

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:05 PM
 */
data class CharacterCacheEntity(
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail
)
