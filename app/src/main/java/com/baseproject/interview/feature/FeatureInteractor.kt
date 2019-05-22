package com.baseproject.interview.feature

import org.koin.android.ext.android.inject

import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.Feature
import com.baseproject.interview.util.computation
import com.baseproject.interview.util.ui
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class FeatureInteractor(private val appRepository: AppRepository) {

    interface OnFinishedListener {

        fun onResultSuccess(data: List<Feature>)

        fun onResultFail(strError: String)
    }

    fun requestDataAPI(onFinishedListener: OnFinishedListener): Disposable = appRepository.getTasks()
        .subscribeOn(computation())
        .observeOn(ui())
        .doOnError { onFinishedListener.onResultFail(it.message ?: "") }
        .subscribe { onNext -> onFinishedListener.onResultSuccess(onNext) }
}
