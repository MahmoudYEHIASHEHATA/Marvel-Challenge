package com.extreme.marvelchallenge.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Item(
    val name: String,
    val resourceURI: String,
    val type: String?
) : Parcelable
