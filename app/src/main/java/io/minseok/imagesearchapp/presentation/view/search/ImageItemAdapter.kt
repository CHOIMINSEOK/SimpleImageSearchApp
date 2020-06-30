package io.minseok.imagesearchapp.presentation.view.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.minseok.imagesearchapp.R
import io.minseok.imagesearchapp.data.model.ImageData

class ImageItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var images: List<ImageData> = listOf()
    set(value) {
        field = value
        Log.d("TAG", value.toString())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageItemViewHolder).onBind(images[position])
    }

    override fun getItemCount(): Int {
        return images.count()
    }
}