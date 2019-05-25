package com.baseproject.interview.feature


import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.Feature
import com.baseproject.interview.util.io
import com.baseproject.interview.util.ui
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
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
                .observeOn(ui())
                .doOnError { getFeatureCallback.onDataNotAvailable(it.message ?: "") }
                .subscribe { onNext -> getFeatureCallback.onFeatureLoaded(onNext) }
        )
    }
}

