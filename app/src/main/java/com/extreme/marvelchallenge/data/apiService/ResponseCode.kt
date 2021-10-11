package com.extreme.marvelchallenge.data.apiService

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 9:38 PM
 */
enum class ResponseCode(val value: Int) {
    OK(200), NETWORK_NOT_AVAILABLE(600), NETWORK_ERROR(
        700
    )
}