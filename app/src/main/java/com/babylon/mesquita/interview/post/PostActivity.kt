package com.babylon.mesquita.interview.post

import android.os.Bundle
import android.util.Log
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PostActivity : DaggerAppCompatActivity(), PostContract.View {

    @Inject
    internal lateinit var postPresenter: PostContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postPresenter.takeView(this)
        postPresenter.loadPosts()
    }

    override fun showPosts(posts: List<Post>) {
        Log.e("test", posts.toString())
    }

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}
