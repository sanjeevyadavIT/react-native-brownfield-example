package com.betatech.react.di

import android.app.Application
import com.betatech.react.BuildConfig
import com.betatech.react.module.NativeLocalStoragePackage
import com.facebook.hermes.reactexecutor.HermesExecutorFactory
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.shell.MainReactPackage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.facebook.react.PackageList

@Module
@InstallIn(SingletonComponent::class)
class ReactNativeModule {

    @Provides
    @Singleton
    fun getReactNativeHost(
        application: Application,
    ): ReactNativeHost {
        return object: DefaultReactNativeHost(application) {
            override fun getPackages(): List<ReactPackage> {
                return PackageList(application).packages.apply {
                    add(NativeLocalStoragePackage())
                }
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