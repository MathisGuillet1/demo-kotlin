package com.qlik.demo.kotlin.showcase

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain

// Just showcasing stuff
class Showcase {

    private val usersById = mapOf(
        "8ab755ba-3db8-4715-bf4e-0627928c2586" to User("Mathis", "mathis@fake.com"),
        "d9163211-4d79-45c4-8ad9-bb35916db86d" to User("John", "john@fake.com")
    )

    fun sendEmailToUser(userId: String) {
        val userEmail = usersById[userId]
            ?.email
            ?: throw IllegalStateException("User with id $userId not found")

        if (userEmail.isNotEmpty()) {
            // Do something with user email...
            println("Sending email to user $userEmail")
        }
    }
}

data class User(val userId: String, val email: String)

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    // Create filter chain with type safe builder
    @Bean
    fun apiFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeRequests {
                authorize("/health/**", permitAll)
                authorize("/metrics", hasAuthority("metrics:read"))
                authorize(anyRequest, authenticated)
            }
            csrf { disable() }
            oauth2ResourceServer {
                jwt {
                    jwkSetUri = "https://idp.example.com/.well-known/jwks.json"
                }
            }
        }

        return http.build()
    }
}