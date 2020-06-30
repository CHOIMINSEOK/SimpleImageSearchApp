package io.minseok.imagesearchapp.data.model

import com.google.gson.annotations.SerializedName

data class ImageSearchResponse(
    @SerializedName("documents") val documents: Array<ImageData>
)