package io.minseok.imagesearchapp.data.remote

import io.minseok.imagesearchapp.data.remote.model.ImageSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageAPIService {
    @GET("search/image")
    fun searchImage(@Query("query") query: String): Single<ImageSearchResponse>
}