package com.extreme.marvelchallenge.presentation.util

import com.extreme.marvelchallenge.presentation.core.Constants
import java.math.BigInteger
import java.security.MessageDigest

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 8:49 PM
 */
fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(this.toByteArray())).toString(Constants.StanderValues.RADIX_MD5)
        .padStart(Constants.StanderValues.LENGTH_MD5, '0')
}