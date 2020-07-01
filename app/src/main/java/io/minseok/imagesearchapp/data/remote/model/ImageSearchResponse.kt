package io.minseok.imagesearchapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class ImageSearchResponse(
    @SerializedName("documents") val documents: List<ImageData>
)