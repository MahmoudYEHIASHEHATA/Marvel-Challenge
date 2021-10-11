package com.extreme.marvelchallenge.data.models.network.stories

import com.extreme.marvelchallenge.data.models.network.Thumbnail

data class StoriesApiModel(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val originalIssue: OriginalIssue,
    val resourceURI: String,
    val series: Series,
    val thumbnail: Thumbnail,
    val title: String,
    val type: String
)