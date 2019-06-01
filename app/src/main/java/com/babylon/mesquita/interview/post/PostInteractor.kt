package com.babylon.mesquita.interview.post


import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.data.makePosts
import com.babylon.mesquita.interview.data.remote.AuthorResponse
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PostInteractor @Inject constructor(private val appRepository: AppDataSource) : PostContract.Interactor {


    private val compositeDisposable = CompositeDisposable()

    interface GetPostCallback {

        fun onPostLoaded(posts: List<Post>)

        fun onPostNotAvailable(strError: String)

    }

    interface GetAuthorCallback {

        fun onAuthorLoaded(authorResponse: List<AuthorResponse>)

        fun onAuthorNotAvailable(strError: String)
    }

    override fun getAuthors(getAuthorsCallback: GetAuthorCallback) {
        compositeDisposable.add(appRepository.requestAuthors()
            .subscribeOn(io())
            .doOnError { error -> getAuthorsCallback.onAuthorNotAvailable(error.message ?: "") }
            .subscribe { authorResponse -> getAuthorsCallback.onAuthorLoaded(authorResponse) }
        )
    }

    override fun getPosts(getPostsCallback: GetPostCallback) {
        val disposable = appRepository.requestData()?.let {
            it.subscribeOn(io())
                .observeOn(mainThread())
                .timeout(50, TimeUnit.SECONDS)
                .doOnError { error -> getPostsCallback.onPostNotAvailable(error.message ?: "") }
                .subscribe { responseData ->
                    val post = responseData.first.makePosts(responseData.second, responseData.third)
                    getPostsCallback.onPostLoaded(post)
                }
        }
        disposable?.let { compositeDisposable.add(it) }
    }

    override fun onDestroy() = compositeDisposable.dispose()
}


