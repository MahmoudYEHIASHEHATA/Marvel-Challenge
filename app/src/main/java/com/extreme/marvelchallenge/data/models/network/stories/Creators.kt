package com.extreme.marvelchallenge.data.models.network.stories

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
