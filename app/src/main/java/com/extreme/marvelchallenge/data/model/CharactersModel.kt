package com.extreme.marvelchallenge.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class CharactersModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: Data?,
    @Json(name = "etag")
    val etAg: String,
    val status: String?
) : Parcelable
