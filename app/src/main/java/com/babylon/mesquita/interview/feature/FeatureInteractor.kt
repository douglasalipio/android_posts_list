package com.baseproject.interview.feature


import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.Feature
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class FeatureInteractor @Inject constructor(private val appRepository: AppDataSource) : FeatureContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    interface GetFeatureCallback {

        fun onFeatureLoaded(data: List<Feature>)

        fun onDataNotAvailable(strError: String)
    }

    override fun requestData(getFeatureCallback: GetFeatureCallback) {
        compositeDisposable.add(
            appRepository.requestData()
                .subscribeOn(io())
                .observeOn(mainThread())
                .doOnError { getFeatureCallback.onDataNotAvailable(it.message ?: "") }
                .subscribe { onNext -> getFeatureCallback.onFeatureLoaded(onNext) }
        )
    }
}

