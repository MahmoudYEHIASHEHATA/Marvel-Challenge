package com.extreme.marvelchallenge.presentation.core

/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 2:09 PM
 */
object Constants {

    object NetworkService {
        const val BASE_URL = " https://gateway.marvel.com:443/v1/public/"
        const val API_KEY_NAME = "apikey"
        const val API_KEY_VALUE = "66a0fe8bb1038e6836fd37db7b65fbcb"
        const val PRIVATE_KEY_VALUE = "0551bdfcdf3f89bbf066474523e40e8b1651c6c9"
        const val API_TS_NAME = "ts"
        const val API_HASH_NAME = "hash"
        const val FIRST_PAGE = 0
        const val START_TOTAL = 0
        const val IMAGE_VARIANT_NAME = "landscape_incredible"
        const val DELAY_TIME_FOR_SEARCH = 300L
    }

    object Splash {
        const val DELAY_TIME = 5000L
    }

    object StanderValues {
        const val TIME_ZONE_UNIT = 1000L
        const val RADIX_MD5 = 16
        const val LENGTH_MD5 = 32
        const val MAX_CASH_VALUE = 10 * 1024 * 1024
    }
}
