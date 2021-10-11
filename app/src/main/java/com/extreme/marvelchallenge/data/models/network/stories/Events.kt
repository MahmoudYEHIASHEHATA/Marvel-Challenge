package com.extreme.marvelchallenge.data.models.network.stories

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)