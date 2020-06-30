package io.minseok.imagesearchapp.domain.repository

import io.minseok.imagesearchapp.data.model.ImageData
import io.reactivex.rxjava3.core.Single

interface ImageRepository {
    fun searchImage(query: String): Single<Array<ImageData>>
}