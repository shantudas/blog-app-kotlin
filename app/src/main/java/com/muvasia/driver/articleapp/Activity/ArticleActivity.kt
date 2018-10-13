package com.muvasia.driver.articleapp.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.muvasia.driver.articleapp.Adapter.ArticleAdapter
import com.muvasia.driver.articleapp.ApiUtils.ApiClient
import com.muvasia.driver.articleapp.ApiUtils.ApiInterface
import com.muvasia.driver.articleapp.Model.Article
import com.muvasia.driver.articleapp.R
import com.muvasia.driver.articleapp.Response.ArticleResponse
import kotlinx.android.synthetic.main.activity_article.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = ArticleActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        Log.e(TAG, " onCreate ::  called")

        rvArticlesList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rvArticlesList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        getArticlesData()

    }


    private fun getArticlesData() {

        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getArticles().enqueue(object : Callback<ArticleResponse> {

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.d("response :: ", t.toString())
            }

            override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
                if (response.isSuccessful) {

                    if (pbArticles.isShown)
                        pbArticles.visibility = View.GONE

                    val articleResponse = response.body()

                    val articles: ArrayList<Article> = articleResponse?.articles!!
                    Log.d("ArticleActivity", "article Size :: " + articles.size)
                    rvArticlesList.adapter = ArticleAdapter(articles, this@ArticleActivity)


                    val metaData = articleResponse.metaData
                    val totalArticles = metaData?.totalArticles
                    val currentPage = metaData?.currentPage
                    Log.e(TAG, "metaData :: " + totalArticles + "--" + currentPage)

                    val articleLinks=articleResponse.links
                    val previousPageUrl=articleLinks?.previousPageUrl
                    val nextPageUrl=articleLinks?.nextPageUrl
                    Log.e(TAG, "links :: " + previousPageUrl + "--" + nextPageUrl)


                    /*var articleTitle: String = ""
                    articles.forEach {
                        articleTitle = articleTitle + it.title + "\n"
                        println(it.title)
                    }
                    Log.e(TAG, "title ::" + articleTitle)*/

                }
            }
        })
    }
}
