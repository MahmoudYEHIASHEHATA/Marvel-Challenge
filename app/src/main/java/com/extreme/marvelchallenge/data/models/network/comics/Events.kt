package com.extreme.marvelchallenge.data.models.network.comics

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)