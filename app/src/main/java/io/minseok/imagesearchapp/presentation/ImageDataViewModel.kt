package io.minseok.imagesearchapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.minseok.imagesearchapp.domain.repository.ImageRepository

class ImageDataViewModel(
    val imageRepository: ImageRepository
): ViewModel() {
    private val _input = MutableLiveData<String>()
    val input: LiveData<String> = _input

    fun updateInput(input: String) {
        imageRepository.searchImage(input)
            .subscribe({
                images ->
                _input.postValue(images.map { it.imageUrl }.toString())
            }, { e ->
                Log.d("LOG", e.message)
            })
   }
}