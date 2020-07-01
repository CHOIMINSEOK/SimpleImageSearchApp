package io.minseok.imagesearchapp.data.local

import io.minseok.imagesearchapp.data.local.model.ImageEntity
import io.minseok.imagesearchapp.domain.Image

object ImageEntityMapper {
    fun mapToEntity(image: Image): ImageEntity {
        return ImageEntity(
            image.imageUrl,
            image.displaySiteName
        )
    }

    fun mapFromEntity(imageEntity: ImageEntity): Image {
        return Image(
            imageEntity.imageUrl,
            imageEntity.displaySiteName
        )
    }
}