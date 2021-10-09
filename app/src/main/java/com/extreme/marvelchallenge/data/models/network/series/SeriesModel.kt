package com.extreme.marvelchallenge.data.models.network.series

data class SeriesModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)