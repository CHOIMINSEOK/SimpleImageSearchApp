package io.minseok.imagesearchapp.domain

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object APIClient {
    val retrofit: Retrofit
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

            val requestHeaderInterceptor = object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    return chain.proceed(chain.request().newBuilder().run {
                        addHeader("Content-Type", "application/json")
                        addHeader("Authorization", "KakaoAK 5d38a7536024ddb0e76443759d038b13")
                        build()
                    })
                }
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(requestHeaderInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com/v2/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

    inline fun <reified T> createWebService(): T {
        return retrofit.create(T::class.java)
    }
}