package com.example.wordgane.core.cashe

import android.content.Context
import android.content.SharedPreferences

class AppCashe private constructor(context: Context) {

    private val KEY_THEME = "THEME_KEY"

    init {
        sharedPreferences = context.getSharedPreferences("cashe", Context.MODE_PRIVATE)
    }

    companion object {
        private var appCashe: AppCashe? = null
        private var sharedPreferences: SharedPreferences? = null

        fun init(context: Context) {

            if (appCashe == null) {
                appCashe = AppCashe(context)
            }

        }

        fun getObject(): AppCashe {
            return appCashe!!
        }
    }

    fun saveTheme(son: Int) {
        sharedPreferences!!.edit().putInt(KEY_THEME, son).apply()
    }

    fun getTheme(): Int {
        return sharedPreferences!!.getInt(KEY_THEME, 0)
    }

}