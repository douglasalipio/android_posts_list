package com.baseproject.interview.di

import android.app.Application
import android.content.Context
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.remote.ApiHelper
import com.baseproject.interview.data.remote.RemoteDataSource
import com.baseproject.interview.data.remote.ServiceAppFactory
import com.baseproject.interview.feature.FeatureActivity
import com.baseproject.interview.feature.FeatureInteractor
import com.baseproject.interview.feature.FeatureModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

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
class InteractorModule {

    @Provides
    @Reusable
    internal fun provideAppInteractor(appRepository: AppRepository): FeatureInteractor =
        FeatureInteractor(appRepository)
}

@Module
class RepositoryModule {

    @Provides
    @Reusable
    internal fun provideAppRepository(apiHelper: ApiHelper): AppRepository =
        AppRepository(RemoteDataSource(apiHelper))
}

@Module
class NetworkModule {

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create(true)
}
