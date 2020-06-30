package io.minseok.imagesearchapp.presentation.view.search

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.minseok.imagesearchapp.data.model.ImageData

object ViewBindingAdapter {
    @BindingAdapter("bind:images")
    @JvmStatic
    fun setImages(recyclerView: RecyclerView, images: List<ImageData>?) {
        if(images != null) (recyclerView.adapter as ImageItemAdapter).images = images
    }
}