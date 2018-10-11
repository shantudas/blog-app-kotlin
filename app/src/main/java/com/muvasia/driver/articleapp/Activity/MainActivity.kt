package com.muvasia.driver.articleapp.Activity

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.muvasia.driver.articleapp.ApiConstant
import com.muvasia.driver.articleapp.ApiInterface
import com.muvasia.driver.articleapp.Model.Article
import com.muvasia.driver.articleapp.R
import com.muvasia.driver.articleapp.response.ArticleResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val api: ApiInterface


    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstant.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(ApiInterface::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getArticlesData()

    }

    private fun getArticlesData() {
        api.getArticles().enqueue(object : Callback<ArticleResponse> {

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.d("response :: ", t.toString())
            }

            override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {

                if (response.isSuccessful) {

                    val articleResponse = response.body()
                    val articles: List<Article> = articleResponse?.articles!!
                    Log.d("MainActivity", "article Size :: " + articles.size)

                    var articleTitle: String = ""
                    articles.forEach {
                        articleTitle = articleTitle + it.title+ "\n"
                        println(it.title)
                    }
                    tvArticleTitle.setText(articleTitle + "")

                }
            }
        })
    }
}
