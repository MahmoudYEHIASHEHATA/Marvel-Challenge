package com.extreme.marvelchallenge.data.models.network.events

data class EventsModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)