package com.muvasia.driver.articleapp

import com.muvasia.driver.articleapp.response.ArticleResponse

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("articles")
     fun getArticles(): Call<ArticleResponse>
}