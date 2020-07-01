package io.minseok.imagesearchapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageEntity(
    @PrimaryKey val imageUrl: String,
    val displaySiteName: String
)