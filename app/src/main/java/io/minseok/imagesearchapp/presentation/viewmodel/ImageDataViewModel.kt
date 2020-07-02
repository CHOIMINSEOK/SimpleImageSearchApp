package io.minseok.imagesearchapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.minseok.imagesearchapp.domain.Image
import io.minseok.imagesearchapp.domain.ImageRepository

class ImageDataViewModel(
    private val imageRepository: ImageRepository
): ViewModel() {
    val images: LiveData<List<Image>> = LiveDataReactiveStreams.fromPublisher(
        imageRepository.observeSearchImage()
    )

    val favoriteImages: LiveData<List<Image>> = LiveDataReactiveStreams.fromPublisher(
        imageRepository.observeFavoriteList()
    )

    fun updateInput(input: String) {
        imageRepository.searchImage(input)
    }

    fun setFavorite(image: Image, favorite: Boolean) {
        when (favorite) {
            true -> {
                imageRepository.setFavorite(image)
                    .subscribe({
                        Log.d("LOG", "즐겨찾기 완료")
                    }, { e ->
                        e.printStackTrace()
                    })
            }

            false -> {
                imageRepository.removeFavorite(image)
                    .subscribe({
                        Log.d("LOG", "즐겨찾기 삭제 완료")
                    }, { e ->
                        e.printStackTrace()
                    })
            }
        }
    }
}