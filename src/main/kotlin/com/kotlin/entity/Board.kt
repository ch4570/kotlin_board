package com.kotlin.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Board (

    @Id @GeneratedValue
    @Column(name = "ARTICLE_NO")
    val id: Long,

    @Column(name = "ARTICLE_TITLE", length = 100)
    val title: String,

    @Column(name = "ARTICLE_CONTENT", columnDefinition = "TEXT")
    val content: String,

    @Column(name = "ARTICLE_COUNT")
    val count: Int,

    @Column(name = "ARTICLE_AUTHOR", length = 30)
    val author: String,

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    var user: User
        ) {

    // 연관관계 편의 메서드
    fun addUser(user: User) {
        this.user = user
        user.boardList.add(this)
    }
}