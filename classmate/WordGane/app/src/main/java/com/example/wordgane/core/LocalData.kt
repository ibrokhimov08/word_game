package com.example.wordgane.core

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.contentValuesOf

object LocalData {


    private val data = ArrayList<GameModel>()

    fun getAllData(context: Context): ArrayList<GameModel> {

        val loadImage = loadImage(context = context)

        data.add(
            GameModel(
                0,
                arrayListOf(loadImage[0], loadImage[1], loadImage[2], loadImage[3]),
                "GOAT",
                "GFASORTYKLMD"
            )
        )

        data.add(
            GameModel(
                1,
                arrayListOf(loadImage[4], loadImage[5], loadImage[6], loadImage[7]),
                "cry",
                "cfdsrtyuyhjk"
            )
        )

        data.add(
            GameModel(
                2,
                arrayListOf(loadImage[8], loadImage[9], loadImage[10], loadImage[11]),
                "key",
                "kyhdergfsyqaz"
            )
        )

        data.add(
            GameModel(
                3,
                arrayListOf(loadImage[12], loadImage[13], loadImage[14], loadImage[15]),
                "Brazil",
                "bharsdihjzlp"
            )
        )

        data.add(
            GameModel(
                4,
                arrayListOf(loadImage[16], loadImage[17], loadImage[18], loadImage[19]),
                "UEFA",
                "ugfehjklmaiw"
            )
        )
        data.add(
            GameModel(
                5,
                arrayListOf(loadImage[20], loadImage[21], loadImage[22], loadImage[23]),
                "ElClas",
                "eflvcaswdlpo"
            )
        )
        return data
    }


    private fun loadImage(context: Context): ArrayList<Drawable> {

        val dList = ArrayList<Drawable>()

        val images = context.assets.list("images")!!

        images.forEach { imageName ->

            if (imageName.startsWith("image_")) {
                val iStream = context.assets.open("images/$imageName")

                val drawable = Drawable.createFromStream(iStream, null)

                drawable?.let { d -> dList.add(d) }
            }


        }

        return dList
    }

}