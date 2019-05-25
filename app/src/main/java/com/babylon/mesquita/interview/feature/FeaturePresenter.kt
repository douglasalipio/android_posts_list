package com.baseproject.interview.feature

import com.baseproject.interview.data.Feature
import com.baseproject.interview.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FeaturePresenter @Inject constructor(private val interactor: FeatureContract.Interactor) :
    FeatureContract.Presenter {

    private var view: FeatureContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as FeatureContract.View
    }

    override fun loadData() {
        view?.let {
            interactor.requestData(object : FeatureInteractor.GetFeatureCallback {
                override fun onFeatureLoaded(data: List<Feature>) {
                    it.showData(data)
                }

                override fun onDataNotAvailable(strError: String) {
                    it.showDataError()
                }
            })
        }
    }

    override fun dropView() {
        view = null
    }
}
