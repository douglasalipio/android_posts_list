package com.baseproject.interview.feature

import com.baseproject.interview.foundation.BasePresenter
import com.baseproject.interview.foundation.BaseView
import com.baseproject.interview.data.Feature
import com.baseproject.interview.foundation.BaseInteractor
import io.reactivex.disposables.Disposable

interface FeatureContract {

    interface View : BaseView<Presenter> {

        fun showData(data: List<Feature>)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadData()
    }

    interface Interactor : BaseInteractor {

        fun requestData(getFeatureCallback: FeatureInteractor.GetFeatureCallback): Disposable
    }
}