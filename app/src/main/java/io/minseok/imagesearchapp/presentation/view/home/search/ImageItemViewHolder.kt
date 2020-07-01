package io.minseok.imagesearchapp.presentation.view.home.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.minseok.imagesearchapp.domain.Image
import io.minseok.imagesearchapp.support.load
import kotlinx.android.synthetic.main.item_image.view.*

class ImageItemViewHolder(
    view: View,
    private val block: (url: String) -> Unit
) : RecyclerView.ViewHolder(view) {
    fun onBind(imageData: Image) {
        with(itemView) {
            tv_sitename.text = imageData.displaySiteName
            img_thumnail.load(imageData.imageUrl)

            img_thumnail.setOnClickListener {
                block.invoke(imageData.imageUrl)
            }
        }
    }
}