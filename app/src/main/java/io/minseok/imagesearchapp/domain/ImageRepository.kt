package io.minseok.imagesearchapp.domain

import io.reactivex.Completable
import io.reactivex.Flowable

interface ImageRepository {
    fun searchImage(query: String)
    fun setFavorite(image: Image): Completable
    fun removeFavorite(image: Image): Completable
    fun observeSearchImage(): Flowable<List<Image>>
    fun observeFavoriteList(): Flowable<List<Image>>
}