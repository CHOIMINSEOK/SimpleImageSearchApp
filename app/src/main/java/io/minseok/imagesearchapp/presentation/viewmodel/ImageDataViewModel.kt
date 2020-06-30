package io.minseok.imagesearchapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.minseok.imagesearchapp.data.model.ImageData
import io.minseok.imagesearchapp.domain.repository.ImageRepository

class ImageDataViewModel(
    val imageRepository: ImageRepository
): ViewModel() {
    private val _images = MutableLiveData<List<ImageData>>()
    val images: LiveData<List<ImageData>> = _images

    fun updateInput(input: String) {
        imageRepository.searchImage(input)
            .subscribe({
                _images.postValue(it.toList())
            }, { e ->
                Log.d("LOG", e.message)
            })
   }
}