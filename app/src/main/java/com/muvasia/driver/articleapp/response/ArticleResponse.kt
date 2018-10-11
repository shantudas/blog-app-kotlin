package com.muvasia.driver.articleapp.response

import com.google.gson.annotations.SerializedName
import com.muvasia.driver.articleapp.Model.Article

/*class ArticleResponse{

    @SerializedName("title")
    var title: String? = null


}*/

class ArticleResponse {

    @SerializedName("data")
    val articles: ArrayList<Article>? = null
}

