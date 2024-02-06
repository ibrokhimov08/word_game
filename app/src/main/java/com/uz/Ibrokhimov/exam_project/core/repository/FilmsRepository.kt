package com.uz.Ibrokhimov.exam_project.core.repository

import com.uz.Ibrokhimov.exam_project.core.model.now.FilmsNowPlayingResponse
import com.uz.Ibrokhimov.exam_project.core.model.popular.FilmsPopularResponse
import com.uz.Ibrokhimov.exam_project.core.network.ApiClient
import com.uz.Ibrokhimov.exam_project.core.util.API_KEY
import com.uz.Ibrokhimov.exam_project.core.util.ResultWrapper

class FilmsRepository {

    private val serviceNow = ApiClient.getFilmsNowPlaying()
    private val servicePopular = ApiClient.getFilmsNowPlaying()

    suspend fun getNowFilms(): ResultWrapper<FilmsNowPlayingResponse> {

        val response = serviceNow.getNowPlaying(API_KEY)

        if (response.isSuccessful) {
            response.body()?.let { return ResultWrapper(it) }
        }

        return ResultWrapper(error = "Error")
    }


    suspend fun getPopularFilms(): ResultWrapper<FilmsPopularResponse> {
        val response = servicePopular.getPopular(API_KEY)

        if (response.isSuccessful) {
            response.body()?.let { return ResultWrapper(it) }
        }
        return ResultWrapper(error = "Error")
    }

}