package com.gsmNetworking.user.domain.mentor.domain

import com.gsmNetworking.user.domain.user.domain.User
import javax.persistence.*

@Entity
class Mentor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id", nullable = false)
    val mentorId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)