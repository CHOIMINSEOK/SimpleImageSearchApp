package io.minseok.imagesearchapp.domain

import io.reactivex.rxjava3.core.Single

interface ImageRepository {
    fun searchImage(query: String): Single<List<Image>>
}