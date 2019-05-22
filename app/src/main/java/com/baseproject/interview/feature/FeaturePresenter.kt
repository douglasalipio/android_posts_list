package com.baseproject.interview.feature

import com.baseproject.interview.data.Feature
import io.reactivex.disposables.CompositeDisposable


class FeaturePresenter(private val featureInteractor: FeatureInteractor) : FeatureContract.Presenter {

    private var view: FeatureContract.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun <T> takeView(view: T) {
        this.view = view as FeatureContract.View
    }

    override fun loadData() {
        view?.let {
            val test = featureInteractor.requestDataAPI(object : FeatureInteractor.OnFinishedListener {
                override fun onResultSuccess(data: List<Feature>) {
                    it.showData(data)
                }

                override fun onResultFail(strError: String) {
                    it.showDataError()
                }
            })
            compositeDisposable.add(test)
        }
    }

    override fun dropView() {
        view = null
    }

}