package com.extreme.marvelchallenge.presentation.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.domain.model.CharacterItem
import com.extreme.marvelchallenge.presentation.ui.home.adapter.CharactersCellAdapter

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 6:27 PM
 */
@BindingAdapter("characterListItems")
fun RecyclerView.characterListItems(items: List<CharacterItem>?) {
    val adapter = this.adapter as CharactersCellAdapter
    adapter.submitList(items)
}

@BindingAdapter(value = ["imagePath", "extension"], requireAll = true)
fun ImageView.loadImageFromPath(
    path: String?,
    extension: String?
) {
    path?.let { pathValue ->
        extension?.let {
            this.loadImageFromPathByGlide(pathValue, it)
        }
    }
}


fun ImageView.loadImageFromPathByGlide(
    path: String,
    extension: String
) {
    val imageUri = "$path${Constants.NetworkService.IMAGE_VARIANT_NAME}$extension"

    Glide.with(context)
        .load(imageUri)
        .placeholder(R.drawable.image_placeholder)
        .into(this)
}
