package com.extreme.marvelchallenge.data.models.network.series

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
