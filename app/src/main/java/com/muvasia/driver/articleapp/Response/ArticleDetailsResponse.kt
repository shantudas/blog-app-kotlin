package com.muvasia.driver.articleapp.Response

import com.google.gson.annotations.SerializedName

class ArticleDetailsResponse {

    // get articles details data
    @SerializedName("data")
    val detailsData: ArticleDetailsResponseData? = null

}

class ArticleDetailsResponseData {

    @SerializedName("id")
    val id: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("body")
    val body: String? = null

    @SerializedName("posted_by")
    val postedBy: String? = null

    @SerializedName("posted_at")
    val postedAt: String? = null

}
