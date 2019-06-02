package com.babylon.mesquita.interview.features.postdetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.post_detail_container.*
import android.view.MenuItem
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.features.comment.CommentActivity
import com.babylon.mesquita.interview.features.comment.CommentActivity.Companion.EXTRA_COMMENTS
import kotlinx.android.synthetic.main.post_detail.*


class PostDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.post_detail_container)
        super.onCreate(savedInstanceState)
        initToolbar()
        loadPostDetail()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initToolbar() {
        postDetailToolbar.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    private fun loadPostDetail() {
        intent.extras?.let { bundle ->
            val post = bundle.getParcelable<Post>(EXTRA_POST_DETAIL)
            post?.let { showPostDetail(it) }
        }
    }

    private fun showPostDetail(post: Post) {
        postDetailTitle.text = post.title
        postBody.text = post.body
        commentButton.setOnClickListener { clickComments(post) }
    }

    private fun clickComments(post: Post) {
        val intent = Intent(this, CommentActivity::class.java)
        intent.putExtra(EXTRA_COMMENTS, post)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_POST_DETAIL = "extra_post_detail"
    }
}
