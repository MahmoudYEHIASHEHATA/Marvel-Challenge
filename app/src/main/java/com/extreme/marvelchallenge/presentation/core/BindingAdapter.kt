package com.extreme.marvelchallenge.presentation.core

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.extreme.marvelchallenge.R
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.domain.DetailCharacterItem
import com.extreme.marvelchallenge.presentation.ui.details.adapter.ComicsCellAdapter
import com.extreme.marvelchallenge.presentation.ui.details.adapter.EventsCellAdapter
import com.extreme.marvelchallenge.presentation.ui.details.adapter.SeriesCellAdapter
import com.extreme.marvelchallenge.presentation.ui.details.adapter.StoriesCellAdapter
import com.extreme.marvelchallenge.presentation.ui.home.adapter.CharactersCellAdapter
import com.extreme.marvelchallenge.presentation.ui.search.adapter.SearchResultCellAdapter


/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 6:27 PM
 */
@BindingAdapter("characterListItems")
fun RecyclerView.characterListItems(items: List<CharacterItem>?) {
    val adapter = this.adapter as CharactersCellAdapter
    adapter.submitList(items)
}

@BindingAdapter("searchResultListItems")
fun RecyclerView.searchResultListItems(items: List<CharacterItem>?) {
    val adapter = this.adapter as SearchResultCellAdapter
    adapter.submitList(items)
}

@BindingAdapter("comicsResultListItems")
fun RecyclerView.comicsResultListItems(items: List<DetailCharacterItem>?) {
    val adapter = this.adapter as ComicsCellAdapter
    adapter.submitList(items)
}

@BindingAdapter("seriesResultListItems")
fun RecyclerView.seriesResultListItems(items: List<DetailCharacterItem>?) {
    val adapter = this.adapter as SeriesCellAdapter
    adapter.submitList(items)
}

@BindingAdapter("storiesResultListItems")
fun RecyclerView.storiesResultListItems(items: List<DetailCharacterItem>?) {
    val adapter = this.adapter as StoriesCellAdapter
    adapter.submitList(items)
}

@BindingAdapter("eventsResultListItems")
fun RecyclerView.eventsResultListItems(items: List<DetailCharacterItem>?) {
    val adapter = this.adapter as EventsCellAdapter
    adapter.submitList(items)
}

@BindingAdapter(value = ["originName", "searchText"])
fun TextView.searchText(name: String, searchText: String) {

    if (searchText.isNotEmpty()) {
        //color your text here
        var index: Int = name.indexOf(searchText)
        val sb = SpannableStringBuilder(name)
        while (index > 0) {
            val fcs = ForegroundColorSpan(resources.getColor(R.color.red_200)) //specify color here
            sb.setSpan(fcs, index, index + searchText.length, Spannable.SPAN_COMPOSING)
            index = name.indexOf(searchText, index + 1)
        }
        this.text = sb
    } else {
        this.text = name
    }
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

    val imageUri = "$path/${Constants.NetworkService.IMAGE_VARIANT_NAME}.$extension"

    Glide.with(context)
        .load(imageUri)
        .placeholder(R.drawable.image_placeholder)
        .error(R.drawable.img_no_image)
        .into(this)
}
