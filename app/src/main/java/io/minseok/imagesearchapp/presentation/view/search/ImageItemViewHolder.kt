package io.minseok.imagesearchapp.presentation.view.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.minseok.imagesearchapp.data.model.ImageData
import io.minseok.imagesearchapp.support.load
import kotlinx.android.synthetic.main.item_image.view.*

class ImageItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(imageData: ImageData) {
        with(itemView) {
            tv_sitename.text = imageData.displaySiteName
            img_thumnail.load(imageData.imageUrl)
        }
    }
}