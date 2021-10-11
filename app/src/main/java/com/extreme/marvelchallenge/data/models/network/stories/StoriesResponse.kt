package com.extreme.marvelchallenge.data.models.network.stories

import com.google.gson.annotations.SerializedName

data class StoriesResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results")
    val storiesApiModels: List<StoriesApiModel>,
    val total: Int
)