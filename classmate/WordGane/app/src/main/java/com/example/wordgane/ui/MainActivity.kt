package com.example.wordgane.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEachIndexed
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.wordgane.R
import com.example.wordgane.core.BaseActivity
import com.example.wordgane.core.GameController
import com.example.wordgane.core.LocalData
import com.example.wordgane.core.cashe.AppCashe
import com.example.wordgane.databinding.ActivityMainBinding
import com.google.android.material.imageview.ShapeableImageView
import gone
import inVisible
import visible
import java.lang.StringBuilder

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gameController: GameController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = LocalData.getAllData(this)

        gameController = GameController(data)


        loadView()
        loadAction()


    }

    private fun loadAction() {

        var answerState = 0
        val answerSize = gameController.getAnswerSize()


        for (i in 0 until binding.variantGroup.childCount) {
            val variant = binding.variantGroup.getChildAt(i) as TextView
            variant.setOnClickListener {
                if (answerState < answerSize && (binding.answerGroup.getChildAt(answerState + 1) as TextView).text == "") {
                    variant.inVisible()
                    val letter = variant.text
                    val textView = binding.answerGroup.getChildAt(answerState) as TextView
                    textView.text = letter
                    textView.tag = variant.tag
                    answerState++

                    if (answerState == answerSize) {
                        val userAnswer = getUserAnswer()

                        if (gameController.checkAnswer(userAnswer)) {
                            if (gameController.isFinish()) {

                                val intent = Intent(this, ResultActivity::class.java)
                                intent.putExtra("Coin", gameController.getCoin())
                                startActivity(intent)
                                finish()

                            } else {
                                loadView()
                            }

                        } else {
                            Toast.makeText(this, "Xato", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        /*for (i in 0 until binding.answerGroup.childCount) {

            val childAnswer = binding.answerGroup.getChildAt(i) as TextView

            childAnswer.setOnClickListener {

                for (j in 0 until binding.variantGroup.childCount) {

                    val childVariant = binding.variantGroup.getChildAt(j) as TextView

                    if (childAnswer.text.toString() == childVariant.text.toString()
                        && childVariant.visibility == View.INVISIBLE && childVariant.tag == childAnswer.tag
                    ) {
                        childAnswer.text = ""
                        childVariant.visible()
                        answerState--
                    }


                }
            }
        }*/

        binding.clearBtn.setOnClickListener {

            if (answerState > 0) {
                val childAnswer = binding.answerGroup.getChildAt(answerState - 1) as TextView
                for (j in 0 until binding.variantGroup.childCount) {
                    val childVariant = binding.variantGroup.getChildAt(j) as TextView

                    if (childAnswer.text.toString() == childVariant.text.toString()
                        && childVariant.visibility == View.INVISIBLE && childVariant.tag == childAnswer.tag
                    ) {
                        childAnswer.text = ""
                        childVariant.visible()
                        answerState--
                    }
                }
            } else {
                return@setOnClickListener
            }


        }

        /**       for (i in 0 until binding.answerGroup.childCount){
        val  whichChild = binding.answerGroup.getChildAt(i) as TextView

        val javob = gameController.getJavob()

        for (j in 0 until  javob.length){
        val letter = javob[j]

        binding.helpBtn.setOnClickListener {


        if (whichChild.text.isEmpty() && whichChild.text[i] == letter){

        Toast.makeText(this, "${letter}", Toast.LENGTH_SHORT).show()

        } else{
        Log.d("TAGaaaa", "loadAction: Error")
        }

        }
        }
        }**/


    }

    private fun getUserAnswer(): String {

        val javob = StringBuilder()

        binding.answerGroup.forEachIndexed { i, _ ->

            val child = binding.answerGroup.getChildAt(i) as TextView

            javob.append(child.text.toString())

        }

        return javob.toString()

    }

    private fun loadView() {

        val def = binding.DefMph


        binding.imageGroup.forEachIndexed { index, _ ->

            val imageView = binding.imageGroup.getChildAt(index) as ShapeableImageView
            val imageData = gameController.getImages()[index]

            imageView.setImageDrawable(imageData)

        }

        val answerSize = gameController.getAnswerSize()

        binding.answerGroup.forEachIndexed { i, _ ->

            val childAt = binding.answerGroup.getChildAt(i) as TextView

            if (i < answerSize) {
                childAt.visible()
            } else {
                childAt.gone()
            }
            childAt.text = ""
        }

        binding.variantGroup.forEachIndexed { i, _ ->

            val child = binding.variantGroup.getChildAt(i) as TextView

            val letter = gameController.getVariant()[i]
            child.tag = i
            child.text = letter.toString().uppercase()
            child.visible()
        }

        binding.level.text = "LEVEL : ${gameController.getLevel()}"

        binding.coin.text = "${gameController.getCoin()}"



        loadAction()


    }


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun setTheme() {
        when (AppCashe.getObject().getTheme()) {
            0 -> {
                binding.DefMph.setImageDrawable(getDrawable(R.drawable.back_photo2))
            }

            1 -> {
                binding.DefMph.setImageDrawable(getDrawable(R.drawable.back_photo3))
            }

            2 -> {
                binding.DefMph.setImageDrawable(getDrawable(R.drawable.back_photo4))

            }
        }
    }
}

