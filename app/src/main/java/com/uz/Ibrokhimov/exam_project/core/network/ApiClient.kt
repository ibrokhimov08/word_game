package com.uz.Ibrokhimov.exam_project.core.network

import com.uz.Ibrokhimov.exam_project.core.network.service.ProjectService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFilmsNowPlaying(): ProjectService {
        return createRetrofit().create(ProjectService::class.java)
    }

}