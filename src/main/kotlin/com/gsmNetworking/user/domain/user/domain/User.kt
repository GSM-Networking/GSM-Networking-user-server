package com.gsmNetworking.user.domain.user.domain

import javax.persistence.*

/**
 * 사용자의 정보를 저장하는 Entity 클래스 입니다.
 */
@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val generation: Int,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val snsUrl: String,

    @Column(nullable = true)
    val profileUrl: String?
)