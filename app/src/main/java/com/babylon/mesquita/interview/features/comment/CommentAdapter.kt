package com.babylon.mesquita.interview.features.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Comment
import kotlinx.android.synthetic.main.comment_card_item.view.*

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.CommentHolder>() {

    private val comments = mutableListOf<Comment>()

    fun addAll(comments: List<Comment>) {
        this.comments.addAll(comments)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_card_item, parent, false)
        return CommentHolder(view)
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        holder.bind(comments[position])
    }

    class CommentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: Comment) {
            with(comment) {
                itemView.commentTitle.text = name
                itemView.responseEmail.text = email
                itemView.comment.text = body
            }
        }
    }
}