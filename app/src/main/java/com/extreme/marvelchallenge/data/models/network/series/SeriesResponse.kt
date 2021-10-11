package com.extreme.marvelchallenge.data.models.network.series

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results")
    val seriesApiModels: List<SeriesApiModel>,
    val total: Int
)
