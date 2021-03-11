package com.app.itunes.network

import com.app.itunes.data.ApiResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("search")
    fun getSongs(
        @Query("term") artist_name: String,
        @Query("limit") limit: Int
    ): Call<ApiResponse>

    companion object {
        operator fun invoke(interceptor: NetworkConnectionInterceptor): ApiCalls {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCalls::class.java)
        }
    }


}