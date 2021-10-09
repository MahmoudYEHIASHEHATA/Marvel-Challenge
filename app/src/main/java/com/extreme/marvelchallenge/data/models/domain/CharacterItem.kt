package com.extreme.marvelchallenge.data.models.domain

import com.extreme.marvelchallenge.data.models.network.character.Thumbnail

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:03 PM
 */
data class CharacterItem(
    val description: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,
)