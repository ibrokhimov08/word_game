package com.example.wordgane.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.forEachIndexed
import com.example.wordgane.core.BaseActivity
import com.example.wordgane.core.cashe.AppCashe
import com.example.wordgane.databinding.ActivitySettingBinding

class SettingActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadAction()

    }

    private fun loadAction() {

        binding.imageGroup.forEachIndexed{i,_ ->

            val imageView = binding.imageGroup.getChildAt(i)  as ImageView

            imageView.setOnClickListener{
                binding.backgrdDef.setImageDrawable(imageView.drawable)

                when(i){
                    0->{AppCashe.getObject().saveTheme(0)}
                    1->{AppCashe.getObject().saveTheme(1)}
                    2->{AppCashe.getObject().saveTheme(2)}
                }
            }

        }

        binding.backButton.setOnClickListener {

            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    override fun setTheme() {

    }



}