package com.uz.Ibrokhimov.exam_project.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uz.Ibrokhimov.exam_project.R
import com.uz.Ibrokhimov.exam_project.databinding.ScreenSplashBinding

class SplashScreen :Fragment (R.layout.screen_splash){

    private val binding by viewBinding(ScreenSplashBinding::bind)
    private var isFirst = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Handler().postDelayed(
            {
                findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen2())
            },
            1500
        )

    }

}