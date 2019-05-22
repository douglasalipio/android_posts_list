package com.baseproject.interview.feature

import com.baseproject.interview.BasePresenter
import com.baseproject.interview.BaseView
import com.baseproject.interview.data.Feature

interface FeatureContract {

    interface FeatureView : BaseView<Presenter> {

        fun showData(data: List<Feature>)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadData()
    }
}