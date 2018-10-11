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


        DisplayProgressDialog()

        getArticlesData()

    }

    private fun getArticlesData() {
        api.getArticles().enqueue(object : Callback<ArticleResponse> {

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {

                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                Log.d("response :: ", t.toString())
            }

            override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {

                Toast.makeText(this@MainActivity, response.isSuccessful.toString(), Toast.LENGTH_LONG).show()

                if (response.isSuccessful) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }
                    val articleResponse = response.body()
                    Log.d("response :: ", articleResponse.toString())
                    var articles: List<Article> = response.body()?.articles!!
                    Log.d("MainActivity", "" + articles.size)
                    var msg: String = ""
                    for (item: Article in articles.iterator()) {
                        msg = msg + item.title + "\n"
                    }
                    tvArticleTitle.setText(msg + "")

                }

            }

        })

    }

    lateinit var pDialog: ProgressDialog
    fun DisplayProgressDialog() {

        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }
}
