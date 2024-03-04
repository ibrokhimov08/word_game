package com.example.wordgane.core

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    override fun onResume() {
        super.onResume()

        setTheme()
    }

    abstract fun setTheme()

}