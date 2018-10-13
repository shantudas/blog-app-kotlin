package com.muvasia.driver.articleapp.ApiUtils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL: String = "https://tranquil-spire-95897.herokuapp.com/api/v1/"
    private var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}