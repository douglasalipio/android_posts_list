package com.babylon.mesquita.interview.post


import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.Avatar
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.data.Result
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

    interface GetAvatarCallback {

        fun onAvatarLoaded(avatar: Avatar)

        fun onAvatarNotAvailable(strError: String)
    }

    override fun requestAvatars(getAvatarsCallback: GetAvatarCallback) {
        compositeDisposable.add(
            appRepository.requestAvatars(10)
                .subscribeOn(io())
                .observeOn(mainThread())
                .doOnError { getAvatarsCallback.onAvatarNotAvailable(it.message ?: "") }
                .subscribe { onNext -> getAvatarsCallback.onAvatarLoaded(onNext) }
        )
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

