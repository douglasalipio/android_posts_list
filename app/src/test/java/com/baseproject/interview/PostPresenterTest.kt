package com.baseproject.interview

import com.babylon.mesquita.interview.data.AppDataSource
import com.babylon.mesquita.interview.features.post.PostContract
import com.babylon.mesquita.interview.features.post.PostInteractor
import com.babylon.mesquita.interview.features.post.PostPresenter
import com.baseproject.interview.dataSet.listOfFakePosts
import com.nhaarman.mockitokotlin2.capture
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*
import org.secfirst.umbrella.misc.launchSilent
import kotlin.coroutines.EmptyCoroutineContext


class PostPresenterTest {
    @Mock
    private lateinit var appRepository: AppDataSource
    @Mock
    private lateinit var view: PostContract.View
    @Mock
    private lateinit var interactor: PostContract.Interactor
    @Captor
    private lateinit var getPostCallbackCaptor: ArgumentCaptor<PostInteractor.GetPostCallback>
    private lateinit var presenter: PostPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PostPresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of posts`() {
        launchSilent(EmptyCoroutineContext) {
            val fakePosts = listOfFakePosts()
            presenter.loadDataBlog()
            verify(interactor).getPosts(capture(getPostCallbackCaptor))
            getPostCallbackCaptor.value.onPostLoaded(fakePosts)
            verify(view).showPosts(fakePosts)
        }
    }

    @Test
    fun `should show an error message`() {
        launchSilent(EmptyCoroutineContext) {
            presenter.loadDataBlog()
            verify(interactor).getPosts(capture(getPostCallbackCaptor))
            getPostCallbackCaptor.value.onPostNotAvailable()
            verify(view).showDataError()
        }
    }
}