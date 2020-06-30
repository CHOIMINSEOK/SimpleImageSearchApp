package io.minseok.imagesearchapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageDataViewModel: ViewModel() {
    private val _input = MutableLiveData<String>()
    val input: LiveData<String> = _input

    fun updateInput(input: String) {
        _input.value = input
        Log.d("TAG", input)
   }
}