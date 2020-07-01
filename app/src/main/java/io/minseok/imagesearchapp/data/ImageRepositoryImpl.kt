package io.minseok.imagesearchapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import io.minseok.imagesearchapp.data.local.ImageEntityDAO
import io.minseok.imagesearchapp.data.local.ImageEntityMapper
import io.minseok.imagesearchapp.domain.ImageRepository
import io.minseok.imagesearchapp.data.remote.ImageAPIService
import io.minseok.imagesearchapp.data.remote.ImageDataMapper
import io.minseok.imagesearchapp.domain.Image
import io.reactivex.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ImageRepositoryImpl(
    private val imageAPIService: ImageAPIService,
    private val imageEntityDAO: ImageEntityDAO
) : ImageRepository {

    override fun searchImage(query: String): Single<List<Image>> {
        return imageAPIService.searchImage(query)
            .subscribeOn(Schedulers.io())
            .flatMap { res ->
                Single.just(res.documents.map(ImageDataMapper::mapFromImageData))
            }
    }

    override fun setFavorite(image: Image): Completable {
        return imageEntityDAO.insert(ImageEntityMapper.mapToEntity(image))
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())

    }

    override fun removeFavorite(image: Image): Completable {
        return imageEntityDAO.delete(ImageEntityMapper.mapToEntity(image))
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
    }

    override fun observeFavoriteList(): LiveData<List<Image>> {
        return Transformations.map(imageEntityDAO.getAll()) { list ->
            list.map(ImageEntityMapper::mapFromEntity)
        }
    }
}