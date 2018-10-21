package com.muvasia.driver.articleapp.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.muvasia.driver.articleapp.ApiUtils.ApiClient
import com.muvasia.driver.articleapp.ApiUtils.ApiInterface
import com.muvasia.driver.articleapp.R
import com.muvasia.driver.articleapp.Response.ArticleDetailsResponse
import kotlinx.android.synthetic.main.activity_article_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleDetailsActivity : AppCompatActivity() {

    private var articleID: String = ""

    companion object {
        private val TAG: String = ArticleDetailsActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        getArticleID()

        getArticleDetails(articleID)


    }

    private fun getArticleID() {
        articleID = intent.getStringExtra("-article-id")
        Log.e(TAG, "articleID :: " + articleID)
    }

    private fun getArticleDetails(articleID: String) {

        val apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getArticleDetails(articleID).enqueue(object : Callback<ArticleDetailsResponse> {

            override fun onFailure(call: Call<ArticleDetailsResponse>, t: Throwable) {
                Log.d(TAG, "onFailure " + t.toString())
            }

            override fun onResponse(call: Call<ArticleDetailsResponse>, response: Response<ArticleDetailsResponse>) {
                if (pbArticleDetails.isShown)
                    pbArticleDetails.visibility = View.GONE

                Log.d(TAG, "onResponse " + response.toString())

                val articleResponse = response.body()
                print(articleResponse)


                val articleDetailsData = articleResponse?.detailsData

                tvArticleTitle.text = articleDetailsData?.title
                tvArticleBody.text = articleDetailsData?.body
                tvArticleTitlePostedBy.text = articleDetailsData?.postedBy
                tvArticleTitlePostedAT.text = articleDetailsData?.postedAt
            }
        })
    }
}
