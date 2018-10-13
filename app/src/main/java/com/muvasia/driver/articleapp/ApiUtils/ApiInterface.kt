package com.muvasia.driver.articleapp.ApiUtils

import com.muvasia.driver.articleapp.Response.ArticleResponse

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("articles")
     fun getArticles(): Call<ArticleResponse>
}