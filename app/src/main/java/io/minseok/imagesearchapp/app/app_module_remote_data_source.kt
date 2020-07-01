package io.minseok.imagesearchapp.app

import io.minseok.imagesearchapp.data.remote.ImageAPIService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val remoteDataSourceAppModule = module {
    single { createOkHttpClient( createRequestHeaderInterceptor(), createLogginInterceptor())}

    single { createRetrofit(get()) }

    single { createWebService<ImageAPIService>(get()) }
}

private fun createRequestHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        chain.proceed(chain.request().newBuilder().run {
            addHeader("Content-Type", "application/json")
            addHeader("Authorization", "KakaoAK 5d38a7536024ddb0e76443759d038b13")
            build()
        })
    }
}

private fun createLogginInterceptor(): Interceptor {
    return HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
        setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }
}

private fun createOkHttpClient(
    requestInterceptor: Interceptor,
    logginInterceptor: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(logginInterceptor)
        .build()
}

private fun createRetrofit(
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dapi.kakao.com/v2/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

inline fun <reified T> createWebService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}