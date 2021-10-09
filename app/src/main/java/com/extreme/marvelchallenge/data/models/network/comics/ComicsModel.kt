package com.extreme.marvelchallenge.data.models.network.comics

data class ComicsModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)