package com.baseproject.interview.di

import com.baseproject.interview.BuildConfig
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.executor.JobExecutor
import com.baseproject.interview.data.executor.PostExecutionThread
import com.baseproject.interview.data.executor.ThreadExecutor
import com.baseproject.interview.data.remote.RemoteDataSource
import com.baseproject.interview.data.remote.ServiceAppFactory
import com.baseproject.interview.util.UiThread
import org.koin.dsl.module

/**
 * DI Module
 */
val applicationModule = module(override = true) {

    factory {
        val apiHelper = ServiceAppFactory.makeServiceApp(BuildConfig.DEBUG)
        AppRepository(RemoteDataSource(apiHelper))
    }
    single { JobExecutor() as ThreadExecutor }
    single { UiThread() as PostExecutionThread }
}
