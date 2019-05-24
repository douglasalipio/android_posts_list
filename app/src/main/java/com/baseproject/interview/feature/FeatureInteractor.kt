package com.baseproject.interview.feature


import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.Feature
import com.baseproject.interview.data.remote.ApiHelper
import com.baseproject.interview.util.io
import com.baseproject.interview.util.ui
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class FeatureInteractor @Inject constructor(private val appRepository: AppRepository) : FeatureContract.Interactor {

    interface OnFinishedListener {

        fun onResultSuccess(data: List<Feature>)

        fun onResultFail(strError: String)
    }

    override fun requestData(onFinishedListener: OnFinishedListener): Disposable = appRepository.requestData()
        .subscribeOn(io())
        .observeOn(ui())
        .doOnError { onFinishedListener.onResultFail(it.message ?: "") }
        .subscribe { onNext -> onFinishedListener.onResultSuccess(onNext) }
}

