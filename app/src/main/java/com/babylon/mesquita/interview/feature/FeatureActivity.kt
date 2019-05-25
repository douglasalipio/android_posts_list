package com.babylon.mesquita.interview.feature

import android.os.Bundle
import android.util.Log
import com.babylon.mesquita.interview.R
import com.baseproject.interview.data.Feature
import com.baseproject.interview.feature.FeatureContract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class FeatureActivity : DaggerAppCompatActivity(), FeatureContract.View {

    @Inject
    internal lateinit var featurePresenter: FeatureContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        featurePresenter.takeView(this)
        featurePresenter.loadData()
    }

    override fun showData(data: List<Feature>) {
        Log.e("test", data.toString())
    }

    override fun showDataError() {
        Log.e("test", "feature error.")
    }
}
