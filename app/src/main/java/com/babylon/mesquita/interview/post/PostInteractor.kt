package com.babylon.mesquita.interview.post


import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.Post
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class PostInteractor @Inject constructor(private val appRepository: AppDataSource) : PostContract.Interactor {


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

