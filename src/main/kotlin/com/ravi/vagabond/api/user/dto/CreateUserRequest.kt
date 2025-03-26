package com.ravi.vagabond.api.user.dto

data class CreateUserRequest(val name: String, val email: String, val mobile: String,
                             val pass: String)