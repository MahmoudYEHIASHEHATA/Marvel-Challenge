package com.extreme.marvelchallenge.data.models.network.comics

import com.google.gson.annotations.SerializedName

data class ComicsResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results")
    val comicsApiModels: List<ComicsApiModel>,
    val total: Int
)
