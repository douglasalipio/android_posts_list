package com.babylon.mesquita.interview.features.comment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Comment
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.databinding.CommentBinding
import com.babylon.mesquita.interview.databinding.CommentContentBinding

class CommentActivity : AppCompatActivity() {

    private val replyClick: () -> Unit = this::clickReplayComment
    private val flagClick: () -> Unit = this::clickFlagComment
    private val recommendClick: () -> Unit = this::clickRecommendComment
    private val adapter = CommentAdapter(replyClick, recommendClick, flagClick)
    private lateinit var commentBinding: CommentBinding
    private lateinit var commentContentBinding: CommentContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comment)
        commentBinding = CommentBinding.inflate(layoutInflater)
        commentContentBinding = CommentContentBinding.inflate(layoutInflater)
        initToolbar()
        loadComments()
        commentBinding.fabComment.setOnClickListener { clickWriteComment(it) }
    }

    private fun clickReplayComment() = defaultMockMessage()

    private fun clickRecommendComment() = defaultMockMessage()

    private fun clickFlagComment() = defaultMockMessage()

    private fun clickWriteComment(view: View) {
        Snackbar.make(view, getString(R.string.create_new_comment_message), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    private fun defaultMockMessage() {
        Toast.makeText(this, getString(R.string.create_new_comment_message), Toast.LENGTH_SHORT)
                .show()
    }

    private fun loadComments() {
        intent.extras?.let { bundle ->
            val post = bundle.getParcelable<Post>(EXTRA_COMMENTS)
            post?.let { showComments(it.comments) }
        }
    }

    private fun showComments(comments: List<Comment>) {
        adapter.addAll(comments)
        commentContentBinding.commentsRecyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
    }

    private fun initToolbar() {
        commentBinding.commentToolbar.let {
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
