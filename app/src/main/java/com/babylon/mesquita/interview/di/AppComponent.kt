package com.baseproject.interview.di

import com.baseproject.interview.FeatureApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        RepositoryModule::class]
)
interface AppComponent : AndroidInjector<FeatureApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: FeatureApplication): Builder

        fun build(): AppComponent
    }
}

