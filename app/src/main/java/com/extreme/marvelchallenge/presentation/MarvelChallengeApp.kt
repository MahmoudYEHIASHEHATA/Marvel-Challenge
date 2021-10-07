package com.extreme.marvelchallenge.presentation

import android.content.Context
import android.content.res.Configuration
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp


/**
 * @author Mahmoud Shehatah
 * Created 07/10/2021 at 12:32 AM
 */
@HiltAndroidApp
class MarvelChallengeApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        MultiDex.install(this)
        super.attachBaseContext(base)
    }
}
