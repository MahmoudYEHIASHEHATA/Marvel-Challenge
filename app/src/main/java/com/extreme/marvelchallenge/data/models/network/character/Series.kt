package com.extreme.marvelchallenge.data.models.network.character

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
