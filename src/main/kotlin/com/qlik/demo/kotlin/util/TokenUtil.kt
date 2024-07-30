package com.qlik.demo.kotlin.util

import org.springframework.security.core.context.SecurityContextHolder
import java.util.*


object TokenUtil {

    fun extractUserId(): UUID? {
        return SecurityContextHolder.getContext()
            .authentication
            ?.principal
            ?.let { it as? AuthUserDetails }
            ?.id
            ?.let { UUID.fromString(it) }
    }
}