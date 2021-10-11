package com.extreme.marvelchallenge.data.models.network.stories

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
