package com.ravi.vagabond.base.dto

data class APIResponse<T>(val status: Int, val message: String, val result: T)
