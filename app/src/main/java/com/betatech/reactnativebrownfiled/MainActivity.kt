package com.betatech.reactnativebrownfiled

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betatech.profile.ProfileFragment
import com.betatech.reactnativebrownfiled.feature.HomeFragment

class MainActivity : AppCompatActivity() {
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
            2 -> HomeFragment()
            else -> HomeFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}