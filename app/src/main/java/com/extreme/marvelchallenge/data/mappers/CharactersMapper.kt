package com.extreme.marvelchallenge.data.mappers

import com.extreme.marvelchallenge.data.db.dao.entity.CharacterCacheEntity
import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.domain.DetailCharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersModel
import com.extreme.marvelchallenge.data.models.network.comics.ComicsApiModel
import com.extreme.marvelchallenge.data.models.network.events.EventsApiModel
import com.extreme.marvelchallenge.data.models.network.series.SeriesApiModel
import com.extreme.marvelchallenge.data.models.network.stories.StoriesApiModel
import javax.inject.Inject

/**
 * @author Mahmoud Shehatah
 * Created 09/10/2021 at 1:30 AM
 */
class CharactersMapper @Inject constructor() {
    fun toCharacterPresentable(characterServer: CharactersModel): CharacterItem {
        return CharacterItem(
            description = characterServer.description,
            id = characterServer.id,
            name = characterServer.name,
            thumbnail = characterServer.thumbnail
        )
    }

    fun toCharacterPresentable(characterCache: CharacterCacheEntity): CharacterItem {
        return CharacterItem(
            description = characterCache.description,
            id = characterCache.id,
            name = characterCache.name,
            thumbnail = characterCache.thumbnail
        )
    }

    fun toComicPresentable(comic: ComicsApiModel): DetailCharacterItem {
        return DetailCharacterItem(
            id = comic.id,
            title = comic.title,
            thumbnail = comic.thumbnail
        )
    }


    fun toSeriesPresentable(comic: SeriesApiModel): DetailCharacterItem {
        return DetailCharacterItem(
            id = comic.id,
            title = comic.title,
            thumbnail = comic.thumbnail
        )
    }

    fun toStoriesPresentable(comic: StoriesApiModel): DetailCharacterItem {
        return DetailCharacterItem(
            id = comic.id,
            title = comic.title,
            thumbnail = comic.thumbnail
        )
    }

    fun toEventsPresentable(comic: EventsApiModel): DetailCharacterItem {
        return DetailCharacterItem(
            id = comic.id,
            title = comic.title,
            thumbnail = comic.thumbnail
        )
    }

    fun toCharacterCache(characterCache: CharactersModel): CharacterCacheEntity {
        return CharacterCacheEntity(
            description = characterCache.description,
            id = characterCache.id,
            name = characterCache.name,
            thumbnail = characterCache.thumbnail
        )
    }
}

