package com.example.wordgane.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.wordgane.R
import com.example.wordgane.core.BaseActivity
import com.example.wordgane.core.cashe.AppCashe
import com.example.wordgane.databinding.ActivityResultBinding

class ResultActivity : BaseActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun setTheme() {
        when (AppCashe.getObject().getTheme()) {
            0 -> {
                binding.image.setBackgroundResource(R.drawable.back_photo2)
            }

            1 -> {
                binding.image.setBackgroundResource(R.drawable.back_photo3)
            }

            2 -> {
                binding.image.setBackgroundResource(R.drawable.back_photo4)
            }
        }

        val dialog = AlertDialog.Builder(this)
            .setTitle("Restart")
            .setIcon(R.drawable.baseline_restart_alt_24)
            .setMessage("Do you want to play again?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ -> startActivity(Intent(this, MainActivity::class.java) )}
            .setNegativeButton("No"){_,_ -> finish()}
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)



        loadView()

    }

    private fun loadView() {

        val coin = intent.getIntExtra("Coin", 0)

        binding.resultCoin.text = "You get $coin coins"



    }
}