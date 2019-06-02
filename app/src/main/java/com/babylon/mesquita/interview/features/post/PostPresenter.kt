package com.babylon.mesquita.interview.features.post

import android.util.Log
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.data.remote.AuthorResponse
import com.babylon.mesquita.interview.data.remote.CommentResponse
import com.babylon.mesquita.interview.data.remote.PostResponse
import com.babylon.mesquita.interview.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PostPresenter @Inject constructor(private val interactor: PostContract.Interactor) :
    PostContract.Presenter {

    private var view: PostContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as PostContract.View
    }

    override fun loadAuthors() {
        view?.let {
            interactor.getAuthors(object :
                PostInteractor.GetAuthorCallback {
                override fun onAuthorLoaded(authorResponse: List<AuthorResponse>) {
                    Log.e("test", authorResponse.toString())
                }

                override fun onAuthorNotAvailable(strError: String) {
                    it.showDataError()
                }
            })
        }
    }

    override fun loadPosts() {
        view?.let {
            interactor.getPosts(object : PostInteractor.GetPostCallback {
                override fun onPostLoaded(posts: List<Post>) {
                    it.showPosts(posts)
                }

                override fun onPostNotAvailable(strError: String) {
                    it.showDataError()
                }
            })
        }
    }

    override fun dropView() {
        view = null
    }
}
