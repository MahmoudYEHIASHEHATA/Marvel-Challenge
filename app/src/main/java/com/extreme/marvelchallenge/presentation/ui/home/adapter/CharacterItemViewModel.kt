package com.extreme.marvelchallenge.presentation.ui.home.adapter

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.extreme.marvelchallenge.domain.model.CharacterItem
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 6:57 PM
 */
class CharacterItemViewModel @Inject internal constructor() : ViewModel() {
    var item = ObservableField<CharacterItem>()
}
