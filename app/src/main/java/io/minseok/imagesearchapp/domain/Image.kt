package io.minseok.imagesearchapp.domain

data class Image(
    val imageUrl: String,
    val displaySiteName: String,
    var favorite: Boolean
)