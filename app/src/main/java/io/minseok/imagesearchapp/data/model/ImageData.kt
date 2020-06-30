package io.minseok.imagesearchapp.data.model

import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("thumnail_url") val thumnailUrl: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("display_sitename") val displaySiteName: String
)