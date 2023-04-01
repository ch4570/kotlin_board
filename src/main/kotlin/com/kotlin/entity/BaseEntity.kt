package com.kotlin.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

        @Column(name = "REG_ID", length = 30)
        open var regId: String? = null

        @Column(name = "REG_DATE")
        @CreatedDate
        open var regDate: LocalDateTime? = null

        @Column(name = "MOD_ID", length = 30)
        open var modId: String? = null

        @Column(name = "MOD_DATE")
        @LastModifiedDate
        open var modDate: LocalDateTime? = null
}




