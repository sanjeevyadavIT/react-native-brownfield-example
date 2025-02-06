package com.betatech.react

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.react.ReactNativeHost
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReactFragment : Fragment() {

    @Inject
    lateinit var reactNativeHost: ReactNativeHost
    var mReactDelegate: CustomReactDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mReactDelegate = CustomReactDelegate(activity, reactNativeHost, "RootComponent", null)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mReactDelegate!!.loadApp()
        return mReactDelegate!!.reactRootView
    }

    override fun onResume() {
        try {
            super.onResume()
            mReactDelegate!!.onHostResume()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPause() {
        try {
            super.onPause()
            mReactDelegate!!.onHostPause()
        } catch (e: AssertionError) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mReactDelegate!!.onHostDestroy()
    }
}