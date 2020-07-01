package io.minseok.imagesearchapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("display_sitename") val displaySiteName: String
)