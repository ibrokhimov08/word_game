package com.uz.Ibrokhimov.exam_project.core.util

data class ResultWrapper<S>(
    val data: S? = null,
    val error: String? = null
)