package com.muvasia.driver.articleapp.ApiUtils

import com.muvasia.driver.articleapp.Response.ArticleDetailsResponse
import com.muvasia.driver.articleapp.Response.ArticleResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @GET("articles")
    fun getArticles(): Call<ArticleResponse>

    @GET("articles/{article_id}")
    fun getArticleDetails(@Path("article_id") id: String): Call<ArticleDetailsResponse>

}