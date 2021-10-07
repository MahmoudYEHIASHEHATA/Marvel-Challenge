package com.extreme.marvelchallenge.presentation.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 06/10/2021 at 11:33 PM
 */
@HiltViewModel
class MainActivityViewModel @Inject internal constructor() : ViewModel() {
    var toolbarTitle: ObservableField<String> = ObservableField()
}
