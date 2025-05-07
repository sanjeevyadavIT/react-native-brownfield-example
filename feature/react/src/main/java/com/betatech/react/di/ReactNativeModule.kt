package com.betatech.react.di

import android.app.Application
import com.betatech.react.BuildConfig
import com.facebook.hermes.reactexecutor.HermesExecutorFactory
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.shell.MainReactPackage
import com.microsoft.codepush.react.CodePush
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
            override fun getPackages(): List<ReactPackage> {
                return listOf(
                    MainReactPackage(),
                    CodePush(
                        "dk_c6b7041b9ab003228c3c6723d6f285aa",
                        application,
                        BuildConfig.DEBUG
                    )
                )
            }

            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

            override fun getJSBundleFile(): String = CodePush.getJSBundleFile() 

            override fun getJavaScriptExecutorFactory() = HermesExecutorFactory()

            override val isHermesEnabled: Boolean?
                get() = true

            override val isNewArchEnabled: Boolean
                get() = false

        }
    }
}