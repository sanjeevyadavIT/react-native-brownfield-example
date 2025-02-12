package com.betatech.react.di

import android.app.Application
import com.betatech.react.BuildConfig
import com.facebook.hermes.reactexecutor.HermesExecutorFactory
import com.facebook.react.ReactNativeHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.shell.MainReactPackage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReactNativeModule {

    @Provides
    @Singleton
    internal fun getReactNativeHost(
        application: Application,
    ): ReactNativeHost {
        return object: DefaultReactNativeHost(application) {
            override fun getPackages(): List<MainReactPackage> {
                return listOf(
                    MainReactPackage()
                )
            }

            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

            override fun getJSMainModuleName(): String = "index"

            override fun getJavaScriptExecutorFactory() = HermesExecutorFactory()

            override val isHermesEnabled: Boolean?
                get() = true

            override val isNewArchEnabled: Boolean
                get() = true

        }
    }
}