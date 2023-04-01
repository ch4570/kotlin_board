package com.kotlin.entity

import javax.persistence.*

@Entity
@Table(name = "USERS")
data class User (

    @Id @GeneratedValue
    @Column(name = "USER_NO")
    var no: Long? = null,

    @Column(name = "USER_ID", unique = true, length = 30)
    var id: String,

    @Column(name = "USER_NAME", length = 20)
    var name: String,

    @Column(name = "USER_PWD", length = 100)
    var pwd: String,

    @Column(name = "USER_EMAIL", length = 100)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    var role: UserRole,

    @OneToMany(mappedBy = "user")
    var boardList: MutableList<Board> = mutableListOf<Board>()

        ): BaseEntity() {

    // equals overriding
    override fun equals(other: Any?): Boolean {

        return if (other == null || other !is User) {
            false
        } else {
            no == other.no && id == other.name && name == other.name
                    && pwd == other.pwd && email == other.email && role == other.role
        }
    }
}