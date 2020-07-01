package io.minseok.imagesearchapp.presentation.view.home.search

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.minseok.imagesearchapp.domain.Image

object ViewBindingAdapter {
    @BindingAdapter("bind:images")
    @JvmStatic
    fun setImages(recyclerView: RecyclerView, images: List<Image>?) {
        if(images != null) (recyclerView.adapter as ImageItemAdapter).images = images
    }
}