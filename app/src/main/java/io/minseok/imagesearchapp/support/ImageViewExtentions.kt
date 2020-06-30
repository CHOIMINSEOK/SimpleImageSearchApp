package io.minseok.imagesearchapp.support

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imageUrl: String) {
    val drawableGlideRequest = Glide.with(this).load(imageUrl)
    drawableGlideRequest.into(this)
}