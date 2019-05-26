package com.babylon.mesquita.interview.feature


import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.Post
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class FeatureInteractor @Inject constructor(private val appRepository: AppDataSource) : FeatureContract.Interactor {


    private val compositeDisposable = CompositeDisposable()

    interface GetPostCallback {

        fun onPostLoaded(posts: List<Post>)

        fun onPostNotAvailable(strError: String)
    }

    override fun requestPosts(getPostsCallback: GetPostCallback) {
        compositeDisposable.add(
            appRepository.requestPosts()
                .subscribeOn(io())
                .observeOn(mainThread())
                .doOnError { getPostsCallback.onPostNotAvailable(it.message ?: "") }
                .subscribe { onNext -> getPostsCallback.onPostLoaded(onNext) }
        )
    }

}

