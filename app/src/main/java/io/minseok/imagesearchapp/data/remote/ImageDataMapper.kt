package io.minseok.imagesearchapp.data.remote

import io.minseok.imagesearchapp.data.remote.model.ImageData
import io.minseok.imagesearchapp.domain.Image

object ImageDataMapper {
    fun mapFromImageData(imageData: ImageData, favorite: Boolean): Image {
        return Image(
            imageData.imageUrl,
            imageData.displaySiteName,
            favorite
        )
    }
}