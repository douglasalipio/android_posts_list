package com.babylon.mesquita.interview.post


import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.assignAtributes
import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.babylon.mesquita.interview.data.remote.PostResponse
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class PostInteractor @Inject constructor(private val appRepository: AppDataSource) : PostContract.Interactor {


    private val compositeDisposable = CompositeDisposable()

    interface GetPostCallback {

        fun onPostLoaded(pair: Pair<List<PostResponse>, List<CommentResponse>>)

        fun onPostNotAvailable(strError: String)

    }

    interface GetAuthorCallback {

        fun onAuthorLoaded(authorResponse: List<AuthorResponse>)

        fun onAuthorNotAvailable(strError: String)
    }

    override fun getAuthors(getAuthorsCallback: GetAuthorCallback) {
        compositeDisposable.add(appRepository.requestAuthorsAndAvatars()
            .subscribeOn(io())
            .doOnError { error -> getAuthorsCallback.onAuthorNotAvailable(error.message ?: "") }
            .subscribe { authorResponse ->
                getAuthorsCallback.onAuthorLoaded(authorResponse)
            }
        )
    }

    override fun getPosts(getPostsCallback: GetPostCallback) {
        appRepository.requestPostsAndComments()?.let {
            compositeDisposable.add(it
                .subscribeOn(io())
                .observeOn(mainThread())
                .doOnError { error -> getPostsCallback.onPostNotAvailable(error.message ?: "") }
                .subscribe { pairRequest ->
                    getPostsCallback.onPostLoaded(pairRequest)
                }
            )
        }
    }
}

