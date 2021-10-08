package com.extreme.marvelchallenge.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
) : Parcelable
