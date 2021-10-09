package com.extreme.marvelchallenge.data.models


/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 10:03 PM
 */
data class GeneralApiResponse<T>(
    val code: Int,
    val status: String,
    val data: T
)
