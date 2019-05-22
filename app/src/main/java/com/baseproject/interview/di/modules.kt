package com.baseproject.interview.di

import com.baseproject.interview.BuildConfig
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.remote.RemoteDataSource
import com.baseproject.interview.data.remote.ServiceAppFactory
import com.baseproject.interview.feature.FeatureInteractor
import com.baseproject.interview.feature.FeaturePresenter
import org.koin.dsl.module

/**
 * DI Module
 */
val applicationModule = module(override = true) {

    factory {
        val apiHelper = ServiceAppFactory.makeServiceApp(BuildConfig.DEBUG)
        val featureInteractor = FeatureInteractor(AppRepository(RemoteDataSource(apiHelper)))
        FeaturePresenter(featureInteractor)
    }

}
