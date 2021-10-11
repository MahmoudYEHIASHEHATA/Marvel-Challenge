package com.extreme.marvelchallenge.data.db.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.extreme.marvelchallenge.data.models.network.Thumbnail

/**
 * @author Mahmoud Shehatah
 * Created 08/10/2021 at 11:05 PM
 */
@Entity(tableName = "Character")
data class CharacterCacheEntity(
    @ColumnInfo(name = "description")
    val description: String,
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @Embedded
    val thumbnail: Thumbnail
)
