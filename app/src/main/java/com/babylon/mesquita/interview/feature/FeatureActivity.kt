package com.babylon.mesquita.interview.feature

import android.os.Bundle
import android.util.Log
import com.babylon.mesquita.interview.R
import com.babylon.mesquita.interview.data.Post
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class FeatureActivity : DaggerAppCompatActivity(), FeatureContract.View {

    @Inject
    internal lateinit var featurePresenter: FeatureContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        featurePresenter.takeView(this)
        featurePresenter.loadPosts()
    }

    override fun showPosts(posts: List<Post>) {
        Log.e("test", posts.toString())
    }

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}