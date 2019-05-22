package com.baseproject.interview.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.baseproject.interview.R
import com.baseproject.interview.data.Feature
import org.koin.android.ext.android.inject

class FeatureActivity : AppCompatActivity(), FeatureContract.View {

    private val featurePresenter: FeaturePresenter by inject()

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
