package com.muvasia.driver.articleapp.Response

import com.google.gson.annotations.SerializedName
import com.muvasia.driver.articleapp.Model.Article

class ArticleResponse {

    // get articles data
    @SerializedName("data")
    val articles: ArrayList<Article>? = null

    @SerializedName("meta")
    val metaData : ArticleResponseMetaDataData? = null

}

class ArticleResponseMetaDataData{
    @SerializedName("total")
    var totalArticles: String? = null

    @SerializedName("current_page")
    var currentPage: String? = null
}

