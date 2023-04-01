package com.kotlin.controller

import com.kotlin.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApiController(
    private val userService: UserService
) {

    @DeleteMapping("/users/{userNo}")
    fun removeUser(@PathVariable("userNo") userNo: Long) {
        userService.removeUser(userNo)
    }
}