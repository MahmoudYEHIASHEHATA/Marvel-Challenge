package com.extreme.marvelchallenge.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
) : Parcelable
