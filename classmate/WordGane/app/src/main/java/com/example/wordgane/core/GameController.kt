package com.example.wordgane.core

import android.graphics.drawable.Drawable

class GameController(private val data: ArrayList<GameModel>) {

    private var currentLevel = 0
    private var coin = 0

    fun getLevel(): Int {
        return currentLevel + 1
    }

    private fun getCurrentLevelData(): GameModel {
        return data[currentLevel]
    }

    fun getImages(): ArrayList<Drawable> {
        return getCurrentLevelData().imageList
    }

     fun getJavob(): String {
        return getCurrentLevelData().answer
    }

    fun getAnswerSize(): Int {
        return getJavob().length
    }

    fun getVariant(): String {
        return getCurrentLevelData().variant
    }


    fun checkAnswer(userAnswer: String): Boolean {

        if (userAnswer.lowercase() == getJavob().lowercase()) {
            currentLevel++
            coin += 5
            return true
        }
        return false
    }

    fun getCoin(): Int {
        return coin
    }

    fun isFinish(): Boolean {

        return currentLevel + 1  == data.size
    }

}