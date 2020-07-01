package io.minseok.imagesearchapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.minseok.imagesearchapp.domain.Image
import io.minseok.imagesearchapp.domain.ImageRepository

class ImageDataViewModel(
    private val imageRepository: ImageRepository
): ViewModel() {
    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    fun updateInput(input: String) {
        imageRepository.searchImage(input)
            .subscribe({
                _images.postValue(it)
            }, { e ->
                Log.d("LOG", e.message)
            })
   }

    fun setFavorite(image: Image, favorite: Boolean) {
        when (favorite) {
            true -> {
                imageRepository.setFavorite(image)
            }

            false -> {
                imageRepository.removeFavorite(image)
            }
        }
    }
}