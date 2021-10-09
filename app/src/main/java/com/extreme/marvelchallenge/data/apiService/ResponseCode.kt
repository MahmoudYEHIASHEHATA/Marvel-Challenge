package com.extreme.marvelchallenge.data.apiService

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 9:38 PM
 */
enum class ResponseCode(val value: Int) {
    OK(200), INVALID_HASH(401), FORBIDDEN(403), INTERNAL_SERVER(500), NETWORK_NOT_AVAILABLE(600), NETWORK_ERROR(
        700
    ),
    GENERAL_ERROR(
        800
    )
}