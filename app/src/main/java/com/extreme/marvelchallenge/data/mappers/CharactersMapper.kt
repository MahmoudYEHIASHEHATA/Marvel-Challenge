package com.extreme.marvelchallenge.data.mappers

import com.extreme.marvelchallenge.data.models.domain.CharacterItem
import com.extreme.marvelchallenge.data.models.network.character.CharactersModel
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
}
