package com.extreme.marvelchallenge.data.models.network.stories

data class StoriesModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)