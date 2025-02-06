package com.betatech.reactnativebrownfiled.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.betatech.reactnativebrownfiled.MainActivity
import com.betatech.reactnativebrownfiled.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnFragmentAndroid = view.findViewById<Button>(R.id.btn_android_fragment)
        val btnFragmentReactNative = view.findViewById<Button>(R.id.btn_react_native_fragment)

        btnFragmentAndroid.setOnClickListener{
            (activity as MainActivity).replaceFragment(1)
        }

        btnFragmentReactNative.setOnClickListener {
            (activity as MainActivity).replaceFragment(2)
        }
    }
}