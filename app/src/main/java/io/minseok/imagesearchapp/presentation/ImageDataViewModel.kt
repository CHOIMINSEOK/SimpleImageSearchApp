package io.minseok.imagesearchapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.minseok.imagesearchapp.domain.service.ImageAPIService
import io.reactivex.rxjava3.schedulers.Schedulers

class ImageDataViewModel(
    val imageApiService: ImageAPIService
): ViewModel() {
    private val _input = MutableLiveData<String>()
    val input: LiveData<String> = _input

    fun updateInput(input: String) {
        imageApiService.searchImage(input)
            .subscribeOn(Schedulers.io())
            .subscribe({ res ->
                _input.postValue(res.toString())
            }, { e ->
                Log.d("LOG", e.message)
            })
   }
}