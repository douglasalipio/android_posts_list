package com.babylon.mesquita.interview.features.post

import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.di.ActivityScoped
import com.babylon.mesquita.interview.util.AppExecutors.Companion.uiContext
import com.babylon.mesquita.interview.util.launchSilent
import javax.inject.Inject

@ActivityScoped
class PostPresenter @Inject constructor(private val interactor: PostContract.Interactor) :
    PostContract.Presenter {

    private var view: PostContract.View? = null

    override fun loadDataBlog() {
        launchSilent(uiContext) {
            interactor.getPosts(object : PostInteractor.GetPostCallback {
                override fun onPostLoaded(posts: List<Post>) {
                    view?.showPosts(posts)
                }

                override fun onPostNotAvailable() {
                    view?.showDataError()
                }
            })
        }
    }

    override fun <T> takeView(view: T) {
        this.view = view as PostContract.View
    }

    override fun dropView() {
        view = null
    }
}
