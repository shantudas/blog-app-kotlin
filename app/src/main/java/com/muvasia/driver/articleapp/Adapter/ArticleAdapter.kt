package com.muvasia.driver.articleapp.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.muvasia.driver.articleapp.Model.Article
import com.muvasia.driver.articleapp.R
import kotlinx.android.synthetic.main.list_each_row_articles.view.*

class ArticleAdapter(
        private val articleList: ArrayList<Article>,
        private val context: Context) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    companion object {
        private val TAG: String = ArticleAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_each_row_articles, parent, false))
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvArticleTitle.text = articleList[position].title
        val author = "Posted by : " + articleList[position].author
        holder.tvArticleAuthor.text = author
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvArticleTitle: TextView = view.tvArticleTitle
        val tvArticleAuthor: TextView = view.tvArticleAuthor
    }
}