package com.muvasia.driver.articleapp.Model

import com.google.gson.annotations.SerializedName

class Article {

    var id: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("posted_by")
    var author: String? = null




}