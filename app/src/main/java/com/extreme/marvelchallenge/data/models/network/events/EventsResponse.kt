package com.extreme.marvelchallenge.data.models.network.events

import com.google.gson.annotations.SerializedName

data class EventsResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results")
    val eventsApiModels: List<EventsApiModel>,
    val total: Int
)
