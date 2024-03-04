package com.example.wordgane.core

import android.graphics.drawable.Drawable

data class GameModel(
    val id:Int,
    val imageList:ArrayList<Drawable>,
    val answer:String,
    val variant:String

)
