package com.extreme.marvelchallenge.data.models.network.character

import com.extreme.marvelchallenge.data.models.network.Thumbnail
import com.extreme.marvelchallenge.data.models.network.Url


data class CharactersModel(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)
