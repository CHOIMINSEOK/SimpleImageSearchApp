package io.minseok.imagesearchapp.domain

import androidx.lifecycle.LiveData
import io.reactivex.Completable
import io.reactivex.Single

interface ImageRepository {
    fun searchImage(query: String): Single<List<Image>>
    fun setFavorite(image: Image): Completable
    fun removeFavorite(image: Image): Completable
    fun observeFavoriteList(): LiveData<List<Image>>
}