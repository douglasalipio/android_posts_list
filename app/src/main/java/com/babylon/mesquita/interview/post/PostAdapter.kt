package com.babylon.mesquita.interview.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post_card_view.view.*

class PostAdapter(private val onPostClick: (Post) -> Unit) : RecyclerView.Adapter<PostAdapter.PostHolder>() {

    private val posts = mutableListOf<Post>()

    fun addAll(posts: List<Post>) {
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_card_view, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(posts[position], clickListener = { onPostClick(posts[position]) })
    }

    override fun getItemCount() = posts.size

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post, clickListener: (PostHolder) -> Unit) {
            itemView.setOnClickListener { clickListener(this) }
            with(post) {
                Picasso.get().load(post.author.avatarUrl).into(itemView.postAvatarImg)
                itemView.postTitle.text = title
                val label = "${comments.size}"
                itemView.postSubtitle.text = label
            }
        }
    }
}