package com.betatech.reactnativebrownfiled

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betatech.profile.ProfileFragment
import com.betatech.react.ReactFragment
import com.betatech.reactnativebrownfiled.feature.HomeFragment
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        }
    }

    fun replaceFragment(id: Int) {
        val fragment = when(id) {
            1 -> ProfileFragment()
            2 -> ReactFragment()
            else -> HomeFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}