package com.baseproject.interview

import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.Feature
import com.baseproject.interview.feature.FeatureContract
import com.baseproject.interview.feature.FeatureInteractor
import com.baseproject.interview.feature.FeaturePresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.capture
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*


class FeaturePresenterTest {
    @Mock
    private lateinit var appRepository: AppDataSource
    @Mock
    private lateinit var view: FeatureContract.View
    @Mock
    private lateinit var interactor: FeatureContract.Interactor
    @Captor
    private lateinit var getFeatureCallbackCaptor: ArgumentCaptor<FeatureInteractor.GetFeatureCallback>
    private lateinit var presenter: FeaturePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = FeaturePresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should return a list of features`() {
        val features = listOfFeature()
        presenter.loadData()
        //`when`(appRepository.requestData()).thenReturn(Flowable.just(features))
        //verify(appRepository).requestData().subscribe()
        verify(interactor).requestData(capture(getFeatureCallbackCaptor))
        getFeatureCallbackCaptor.value.onFeatureLoaded(features)
        verify(view).showData(features)
    }

    @Test
    fun `should show a error message`() {
        presenter.loadData()
        verify(interactor).requestData(capture(getFeatureCallbackCaptor))
        getFeatureCallbackCaptor.value.onDataNotAvailable("data not available.")
        verify(view).showDataError()
    }
}