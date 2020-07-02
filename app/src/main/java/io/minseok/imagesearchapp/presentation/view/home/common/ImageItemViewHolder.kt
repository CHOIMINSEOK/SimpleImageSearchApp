package io.minseok.imagesearchapp.presentation.view.home.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.minseok.imagesearchapp.domain.Image
import io.minseok.imagesearchapp.presentation.view.home.search.Action
import io.minseok.imagesearchapp.support.extensions.load
import kotlinx.android.synthetic.main.item_image.view.*

class ImageItemViewHolder(
    view: View,
    private val block: (action: Action) -> Unit
) : RecyclerView.ViewHolder(view) {
    fun onBind(image: Image) {
        with(itemView) {
            tv_sitename.text = image.displaySiteName
            img_thumnail.load(image.imageUrl)

            img_thumnail.setOnClickListener {
                block.invoke(
                    Action.GoDetail(
                        image.imageUrl
                    )
                )
            }

            switch_favorite.setOnCheckedChangeListener(null)
            switch_favorite.isChecked = image.favorite

            switch_favorite.setOnCheckedChangeListener { _, isChecked ->
                block.invoke(
                    Action.SetFavorite(
                        image,
                        isChecked
                    )
                )
            }
        }
    }
}