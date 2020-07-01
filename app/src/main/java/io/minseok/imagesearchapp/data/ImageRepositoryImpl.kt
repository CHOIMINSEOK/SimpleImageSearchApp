package io.minseok.imagesearchapp.data

import io.minseok.imagesearchapp.domain.ImageRepository
import io.minseok.imagesearchapp.data.remote.ImageAPIService
import io.minseok.imagesearchapp.data.remote.ImageDataMapper
import io.minseok.imagesearchapp.domain.Image
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ImageRepositoryImpl(
    private val imageAPIService: ImageAPIService
) : ImageRepository {

    override fun searchImage(query: String): Single<List<Image>> {
        return imageAPIService.searchImage(query)
            .subscribeOn(Schedulers.io())
            .flatMap { res ->
                Single.just(res.documents.map(ImageDataMapper::mapFromImageData))
            }
    }
}