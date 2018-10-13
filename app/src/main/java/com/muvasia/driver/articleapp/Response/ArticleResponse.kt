package com.muvasia.driver.articleapp.Response

import com.google.gson.annotations.SerializedName
import com.muvasia.driver.articleapp.Model.Article

/**
 * Get article response
 *
 * @param @null
 */
class ArticleResponse {

    // get articles data
    @SerializedName("data")
    val articles: ArrayList<Article>? = null

    // getting article meta data :: total article, current page, per page, url path etc...
    @SerializedName("meta")
    val metaData: ArticleResponseMetaDataData? = null

    // getting article's links :: previous page url, next page url, first page url, last page url
    @SerializedName("links")
    val links: ArticleResponseLinks? = null

}

/**
 * Get meta data like count total articles , current page number
 *
 * @param @null
 */
class ArticleResponseMetaDataData {
    @SerializedName("total")
    var totalArticles: String? = null

    @SerializedName("current_page")
    var currentPage: String? = null
}

/**
 * Get response links like previous, next , first and last page url
 *
 * @param @null
 */
class ArticleResponseLinks {
    @SerializedName("prev")
    val previousPageUrl: String? = null

    @SerializedName("next")
    val nextPageUrl: String? = null

    @SerializedName("first")
    val firstPageUrl: String? = null

    @SerializedName("last")
    val lastPageUrl: String? = null
}

