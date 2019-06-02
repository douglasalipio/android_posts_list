package com.babylon.mesquita.interview.features.comment

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post

import kotlinx.android.synthetic.main.comment.*
import kotlinx.android.synthetic.main.comment_content.*
import kotlinx.android.synthetic.main.post_detail_container.*

class CommentActivity : AppCompatActivity() {

    private val adapter = CommentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comment)
        loadComments()
        initToolbar()
        fabComment.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.create_new_comment_message), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun loadComments() {
        intent.extras?.let { bundle ->
            val post = bundle.getParcelable<Post>(EXTRA_COMMENTS)
            post?.let { showComments(it.comments) }
        }
    }

    private fun showComments(comments: List<Comment>) {
        adapter.addAll(comments)
        commentsList?.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
    }

    private fun initToolbar() {
        commentToolbar.let {
            setSupportActionBar(it)
            supportActionBar?.setDisplayShowTitleEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.title = "Comments"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_COMMENTS = "extra_comments"
    }
}
