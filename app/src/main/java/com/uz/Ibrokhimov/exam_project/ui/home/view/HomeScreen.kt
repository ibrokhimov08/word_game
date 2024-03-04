package com.uz.Ibrokhimov.exam_project.ui.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uz.Ibrokhimov.exam_project.R
import com.uz.Ibrokhimov.exam_project.core.model.base.BaseModel
import com.uz.Ibrokhimov.exam_project.databinding.ScreenHomeBinding
import com.uz.Ibrokhimov.exam_project.ui.home.vm.HomeScreenVM
import uz.ibrokhimov.mynewsapi.core.adapter.MultiAdapter


class HomeScreen : Fragment(R.layout.screen_home) {

    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val homeVM: HomeScreenVM by viewModels()
    private val multiData = ArrayList<BaseModel>()
    private var one = false
    private var two = false
    private val adapter by lazy { MultiAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeVM.getFilmsData()
        observer()
        setAdapter()
        loadAction()
    }

    private fun loadAction() {

        adapter.setOnClickBanner = {

            findNavController().navigate(HomeScreenDirections.homeToDetail(it))

        }

    }

    private fun setAdapter() {
        multiData.clear()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun observer() {

        homeVM.filmsNowLiveData.observe(requireActivity()) {
            multiData.add(it!!)
            one = true
            if (this.one && two) {
                this.adapter.setData(multiData)
            }
        }
        homeVM.filmsPopularLiveData.observe(requireActivity()) {
            multiData.add(it!!)
            two = true
            if (one && this.two) {
                this.adapter.setData(multiData)
            }
        }


    }


}