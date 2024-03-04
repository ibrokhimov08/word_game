package com.uz.Ibrokhimov.exam_project.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.uz.Ibrokhimov.exam_project.R
import com.uz.Ibrokhimov.exam_project.databinding.ScreenDetailBinding

class DetailScreen :Fragment(R.layout.screen_detail){

    private val binding by viewBinding(ScreenDetailBinding::bind)
    private val args by navArgs<DetailScreenArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadView()
        loadAction()

    }

    private fun loadAction() {

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun loadView() {

        binding.text.text = args.data.title
        binding.title.text = args.data.originalTitle
        binding.image.load("https://image.tmdb.org/t/p/original${args.data.backdropPath}")
        binding.about.text = args.data.overview

    }

}