package com.kotlin.service

import com.kotlin.entity.User
import com.kotlin.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository
        ) {


    // 회원가입
    @Transactional
    fun join(user: User): User {
        isDuplicate(user)

        return userRepository.save(user)
    }

    // 회원 한명조회
    @Transactional
    fun findOneUser(userNo: Long): User {
        return userRepository.findById(userNo)
            .orElseThrow{ IllegalArgumentException("조회하려는 회원은 존재하지 않습니다.") }
    }

    // 회원 한명 이름으로 조회
    @Transactional
    fun findOneUserByName(name: String): User? {
        return userRepository.findByName(name)
    }

    // 회원 한명 업데이트
    @Transactional
    fun modifyUser(user: User): User {
        return userRepository.save(user)
    }

    // 회원 한명 삭제
    @Transactional
    fun removeUser(userNo: Long) {
        val findUser = userRepository.findById(userNo).orElseThrow{ IllegalArgumentException("조회하려는 회원은 존재하지 않습니다.") }
        userRepository.delete(findUser)
    }

    // 회원 전체 삭제
    @Transactional
    fun removeAllUsers() {
        userRepository.deleteAll()
    }

    // 회원 전체 조회
    fun findAllUsers(): List<User> {
        return userRepository.findAll()
    }

    private fun isDuplicate(user: User): Boolean {
        val findUser = userRepository.findByName(user.name)

        if (findUser == null) {
            return true
        } else {
            throw IllegalArgumentException("이미 존재하는 회원입니다.")
        }
    }
}