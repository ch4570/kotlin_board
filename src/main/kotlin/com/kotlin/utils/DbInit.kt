package com.kotlin.utils

import com.kotlin.entity.User
import com.kotlin.entity.UserRole
import com.kotlin.service.UserService
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DbInit (
    private val userService: UserService
        ) {


    @PostConstruct
    fun init() {
        val user1 = User(
            id = "Kafka",
            pwd = "javascript",
            email = "aaa@aaa.com",
            name = "RexSeo",
            role = UserRole.USER
        )

        val user2 = User(
            id = "Redis",
            pwd = "react",
            email = "bbb@bbb.com",
            name = "DevSeo",
            role = UserRole.USER
        )

        val user3 = User(
            id = "ElasticSearch",
            pwd = "Vue.js",
            email = "ccc@ccc.com",
            name = "Hodong",
            role = UserRole.USER
        )

        userService.join(user1)
        userService.join(user2)
        userService.join(user3)
    }
}