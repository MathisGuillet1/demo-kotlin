package com.qlik.demo.kotlin.util

import java.security.Principal

data class AuthUserDetails(
    val id: String,
    val userName: String
) : Principal {
    override fun getName() = userName
}
