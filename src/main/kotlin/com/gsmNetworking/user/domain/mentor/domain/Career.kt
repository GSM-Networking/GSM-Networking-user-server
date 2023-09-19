package com.gsmNetworking.user.domain.mentor.domain

import com.gsmNetworking.user.domain.user.domain.User
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Career(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id", nullable = false)
    var careerId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @Column(nullable = false)
    val companyName: String,

    @Column(nullable = false)
    val companyUrl: String,

    @Column(nullable = false)
    val position: String,

    @Column(nullable = false)
    val startDate: LocalDateTime,

    @Column(nullable = false)
    val endDate: LocalDateTime,

    @Column(nullable = false)
    val isWorking: Boolean
)