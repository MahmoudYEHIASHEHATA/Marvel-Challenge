package com.extreme.marvelchallenge.data.models.network.events

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
