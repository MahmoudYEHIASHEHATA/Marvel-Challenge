package com.extreme.marvelchallenge.data.models.network.character

import com.google.gson.annotations.SerializedName


data class CharactersResponse(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val total: Int,
    @SerializedName("results")
    val charactersModels: ArrayList<CharactersModel>
)

