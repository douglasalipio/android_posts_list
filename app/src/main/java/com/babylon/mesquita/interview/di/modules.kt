package com.baseproject.interview.di

import android.app.Application
import android.content.Context
import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.remote.ApiHelper
import com.baseproject.interview.data.remote.RemoteDataSource
import com.baseproject.interview.data.remote.ServiceAppFactory
import com.babylon.mesquita.interview.feature.FeatureActivity
import com.baseproject.interview.feature.FeatureModule
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [FeatureModule::class])
    abstract fun featureAcitivity(): FeatureActivity
}

@Module
class AppModule {

    @Provides
    @Reusable
    internal fun provideContext(application: Application): Context = application
}

@Module
class RepositoryModule {

    @Provides
    @Reusable
    internal fun provideAppRepository(remoteDataSource: RemoteDataSource): AppDataSource =
        AppRepository(remoteDataSource)
}

@Module
class NetworkModule {

    @Provides
    @Reusable
    internal fun provideRemoteRepository(apiHelper: ApiHelper): RemoteDataSource =
        RemoteDataSource(apiHelper)

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create(true)
}
