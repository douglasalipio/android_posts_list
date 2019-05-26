package com.babylon.mesquita.interview.feature

import android.util.Log
import com.babylon.mesquita.interview.data.Post
import com.babylon.mesquita.interview.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class FeaturePresenter @Inject constructor(private val interactor: FeatureContract.Interactor) :
    FeatureContract.Presenter {


    private var view: FeatureContract.View? = null

    override fun <T> takeView(view: T) {
        this.view = view as FeatureContract.View
    }

    override fun loadPosts() {
        view?.let {
            interactor.requestPosts(object : FeatureInteractor.GetPostCallback {
                override fun onPostLoaded(posts: List<Post>) {
                    it.showPosts(posts)
                }

                override fun onPostNotAvailable(strError: String) {
                    it.showDataError()
                }
            })
        }
    }

    override fun loadAuthors() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadComments() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dropView() {
        view = null
    }
}
