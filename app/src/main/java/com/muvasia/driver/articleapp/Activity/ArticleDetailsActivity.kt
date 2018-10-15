package com.muvasia.driver.articleapp.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.muvasia.driver.articleapp.R

class ArticleDetailsActivity : AppCompatActivity() {

    companion object {
        private val TAG: String = ArticleDetailsActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        val articleID = intent.getStringExtra("-article-id")
        Log.e(TAG + "articleID", articleID)
    }
}
