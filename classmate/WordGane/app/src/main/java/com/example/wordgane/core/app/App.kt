package com.example.wordgane.core.app

import android.app.Application
import com.example.wordgane.core.cashe.AppCashe
import com.example.wordgane.core.LocalData

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCashe.init(this)
    }

}