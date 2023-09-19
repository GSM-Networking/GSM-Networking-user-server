package com.gsmNetworking.user.domain.user.domain

import javax.persistence.*

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

    @Column(columnDefinition = "TEXT", nullable = false)
    val snsUrl: String,

    @Column(nullable = true)
    val profileUrl: String?
)