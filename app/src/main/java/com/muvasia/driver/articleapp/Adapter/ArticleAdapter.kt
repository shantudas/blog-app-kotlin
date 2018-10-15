package com.muvasia.driver.articleapp.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.muvasia.driver.articleapp.Activity.ArticleDetailsActivity
import com.muvasia.driver.articleapp.Model.Article
import com.muvasia.driver.articleapp.R
import kotlinx.android.synthetic.main.list_each_row_articles.view.*

class ArticleAdapter(
        private val articleList: ArrayList<Article>,
        private val context: Context
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

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

        val article = articleList[position]
        holder.setData(article, position)

        /*  holder.tvArticleTitle.text = article.title
          holder.tvArticleAuthor.text = article.author
          holder.tvArticlePostedAt.text = article.postedAt*/
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentArticle: Article? = null
        private var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ArticleDetailsActivity::class.java)
                intent.putExtra("-article-id",currentArticle!!.id)
                itemView.context.startActivity(intent)
            }
        }

        fun setData(article: Article, position: Int) {
            this.currentPosition = position
            this.currentArticle = article

            itemView.tvArticleTitle.text = article.title

        }
        /*val tvArticleTitle: TextView = view.tvArticleTitle
        val tvArticleAuthor: TextView = view.tvArticleAuthor
        val tvArticlePostedAt: TextView = view.tvArticlePostedAt*/
    }


}