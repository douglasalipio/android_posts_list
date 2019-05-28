package com.babylon.mesquita.interview.post


import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.remote.AuthorDTO
import com.babylon.mesquita.interview.data.remote.AvatarDTO
import com.babylon.mesquita.interview.data.remote.CommentDTO
import com.babylon.mesquita.interview.data.remote.PostDTO
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class PostInteractor @Inject constructor(private val appRepository: AppDataSource) : PostContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

    interface GetPostCallback {

        fun onPostLoaded(triple: Triple<List<PostDTO>, List<CommentDTO>, List<AuthorDTO>>)

        fun onPostNotAvailable(strError: String)
    }

    interface GetAvatarCallback {

        fun onAvatarLoaded(avatar: AvatarDTO)

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
        appRepository.requestData()?.let {
            compositeDisposable.add(it
                .subscribeOn(io())
                .observeOn(mainThread())
                .doOnError { error -> getPostsCallback.onPostNotAvailable(error.message ?: "") }
                .subscribe { onNext -> getPostsCallback.onPostLoaded(onNext) }
            )
        }
    }
}

