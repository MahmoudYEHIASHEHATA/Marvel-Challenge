package com.extreme.marvelchallenge.data.shared

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 10:16 PM
 */
class AppNetworkManager @Inject constructor(@ApplicationContext val context: Context) {
    fun isConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return (cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnectedOrConnecting)
    }
}
