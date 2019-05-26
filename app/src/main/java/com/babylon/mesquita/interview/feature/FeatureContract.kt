package com.babylon.mesquita.interview.feature

import com.babylon.mesquita.interview.foundation.BasePresenter
import com.babylon.mesquita.interview.foundation.BaseView
import com.babylon.mesquita.interview.data.Feature
import com.babylon.mesquita.interview.foundation.BaseInteractor

interface FeatureContract {

    interface View : BaseView<Presenter> {

        fun showData(data: List<Feature>)
        fun showDataError()
    }

    interface Presenter : BasePresenter {
        fun loadData()
    }

    interface Interactor : BaseInteractor {

        fun requestData(getFeatureCallback: FeatureInteractor.GetFeatureCallback)
    }
}