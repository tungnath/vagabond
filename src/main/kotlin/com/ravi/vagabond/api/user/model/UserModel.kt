package com.ravi.vagabond.api.user.model

import jakarta.persistence.*


@Entity
class UserModel(
    @Column(name = "name") val name: String,
    @Column(name = "email") val email: String,
    @Column(name = "mobile") val mobile: String,
    @Column(name = "pass") val pass: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?=null,
)