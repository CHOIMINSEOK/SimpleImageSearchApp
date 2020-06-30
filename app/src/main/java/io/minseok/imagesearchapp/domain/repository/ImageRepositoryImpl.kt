package io.minseok.imagesearchapp.domain.repository

import io.minseok.imagesearchapp.data.model.ImageData
import io.minseok.imagesearchapp.domain.service.ImageAPIService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ImageRepositoryImpl(
    val imageAPIService: ImageAPIService
) : ImageRepository {

    override fun searchImage(query: String): Single<Array<ImageData>> {
        return imageAPIService.searchImage(query)
            .subscribeOn(Schedulers.io())
            .flatMap { res ->
                Single.just(res.documents)
            }
    }
}