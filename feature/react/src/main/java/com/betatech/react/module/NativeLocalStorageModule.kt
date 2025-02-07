package com.betatech.react.module

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.nativelocalstorage.NativeLocalStorageSpec

class NativeLocalStorageModule(reactContext: ReactApplicationContext) : NativeLocalStorageSpec(reactContext) {
    override fun getName() = NAME

    override fun setItem(value: String, key: String) {
        Log.d("SANJEEV", "key=$key, value=$value")
    }

    companion object {
        const val NAME = "NativeLocalStorage"
    }
}