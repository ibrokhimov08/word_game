package com.uz.Ibrokhimov.exam_project.core.model.base

abstract class BaseModel {


    companion object {
        const val NOW_PLAYING = 0
        const val POPULAR = 1
    }

    abstract fun getType(): Int

}