package com.betatech.react

import android.app.Activity
import android.os.Bundle
import com.facebook.react.ReactDelegate
import com.facebook.react.ReactNativeHost
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost

class CustomReactDelegate(
    val activity: Activity?,
    val reactNativeHost: ReactNativeHost,
    appKey: String,
    launchOptions: Bundle?
): ReactDelegate(
    activity,
//    getDefaultReactHost(activity!!.applicationContext, reactNativeHost),
    reactNativeHost,
    appKey,
    launchOptions
) {
}