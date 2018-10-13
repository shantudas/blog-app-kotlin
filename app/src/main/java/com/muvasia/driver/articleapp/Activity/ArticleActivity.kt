package com.muvasia.driver.articleapp.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.muvasia.driver.articleapp.Adapter.ArticleAdapter
import com.muvasia.driver.articleapp.Model.Article
import com.muvasia.driver.articleapp.R
import kotlinx.android.synthetic.main.activity_article.*


class ArticleActivity : AppCompatActivity() {

    /*private val api: ApiInterface


    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstant.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(ApiInterface::class.java)
    }*/

    companion object {
        private val TAG: String = ArticleActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        Log.e(TAG, " onCreate ::  called")

        rvArticlesList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val articles = ArrayList<Article>()
        articles.add(Article("This is an article title"))
        articles.add(Article("This is an article title 2"))
        articles.add(Article("This is an article title 3"))

        val adapter = ArticleAdapter(articles, this)
        rvArticlesList.adapter = adapter

//        getArticlesData()

    }


    /*private fun getArticlesData() {
        api.getArticles().enqueue(object : Callback<ArticleResponse> {

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.d("response :: ", t.toString())
            }

            override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {

                if (response.isSuccessful) {

                    val articleResponse = response.body()
                    val articles: List<Article> = articleResponse?.articles!!
                    Log.d("ArticleActivity", "article Size :: " + articles.size)

                    var articleTitle: String = ""
                    articles.forEach {
                        articleTitle = articleTitle + it.title+ "\n"
                        println(it.title)
                    }
                    tvArticleTitle.setText(articleTitle + "")

                }
            }
        })
    }*/
}
