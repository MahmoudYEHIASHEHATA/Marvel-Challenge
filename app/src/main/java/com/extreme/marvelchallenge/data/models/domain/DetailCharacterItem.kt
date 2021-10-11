package com.extreme.marvelchallenge.data.models.domain

import com.extreme.marvelchallenge.data.models.network.Thumbnail

/**
 * @author Mahmoud Shehatah
 * Created 10/10/2021 at 11:26 AM
 */
data class DetailCharacterItem(
    val id: Int,
    val thumbnail: Thumbnail?,
    val title: String,
)
