package com.ravi.vagabond.api.user.dto

class UserResponse {

    private var name: String? = null
    private var email: String? = null
    private var mobile: String? = null

    constructor()

    constructor(name: String, email: String, mobile: String) {
        this.name = name
        this.email = email
        this.mobile = mobile
    }

}
