package io.minseok.imagesearchapp.data

import io.minseok.imagesearchapp.data.local.ImageEntityDAO
import io.minseok.imagesearchapp.data.local.ImageEntityMapper
import io.minseok.imagesearchapp.domain.ImageRepository
import io.minseok.imagesearchapp.data.remote.ImageAPIService
import io.minseok.imagesearchapp.data.remote.ImageDataMapper
import io.minseok.imagesearchapp.domain.Image
import io.minseok.imagesearchapp.support.rx.SchedulerProvider
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.rxkotlin.Flowables
import io.reactivex.subjects.PublishSubject

class ImageRepositoryImpl(
    private val imageAPIService: ImageAPIService,
    private val imageEntityDAO: ImageEntityDAO,
    private val schedulerProvider:  SchedulerProvider
) : ImageRepository {

    private val queryPublish: PublishSubject<String> = PublishSubject.create()

    override fun searchImage(query: String) {
        queryPublish.onNext(query)
    }

    override fun setFavorite(image: Image): Completable {
        return imageEntityDAO.insert(ImageEntityMapper.mapToEntity(image))
            .subscribeOn(schedulerProvider.io())

    }

    override fun removeFavorite(image: Image): Completable {
        return imageEntityDAO.delete(ImageEntityMapper.mapToEntity(image))
            .subscribeOn(schedulerProvider.io())
    }

    override fun observeSearchImage(): Flowable<List<Image>> {
        return Flowables.combineLatest(
            queryPublish.toFlowable(BackpressureStrategy.LATEST).switchMapSingle {
                imageAPIService.searchImage(it)
                    .subscribeOn(schedulerProvider.io()).map { it.documents }
            },
            imageEntityDAO.getAll()
        ).map { (imageDataList, favorites) ->
            imageDataList.map { imageData ->
                ImageDataMapper.mapFromImageData(
                    imageData,
                    favorites.find { it.imageUrl == imageData.imageUrl } != null
                )
            }
        }

    }

    override fun observeFavoriteList(): Flowable<List<Image>> {
        return imageEntityDAO.getAll().map{ list ->
            list.map { entity ->
                ImageEntityMapper.mapFromEntity(entity, true)
            }
        }
    }
}