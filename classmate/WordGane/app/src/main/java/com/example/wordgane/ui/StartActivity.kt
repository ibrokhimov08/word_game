package com.example.wordgane.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.example.wordgane.R
import com.example.wordgane.core.BaseActivity
import com.example.wordgane.core.cashe.AppCashe
import com.example.wordgane.databinding.ActivityStartBinding

class StartActivity : BaseActivity() {

    private lateinit var binding: ActivityStartBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun setTheme() {

        when (AppCashe.getObject().getTheme()) {
            0 -> {
                binding.DefSph.setImageDrawable(getDrawable(R.drawable.back_photo2))
            }

            1 -> {
                binding.DefSph.setImageDrawable(getDrawable(R.drawable.back_photo3))

            }

            2 -> {
                binding.DefSph.setImageDrawable(getDrawable(R.drawable.back_photo4))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        loadView()


    }

    private fun loadView() {


        binding.startButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.settingButton.setOnClickListener {

            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

    }


}