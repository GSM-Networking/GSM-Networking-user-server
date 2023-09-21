package com.gsmNetworking.user.domain.mentor.domain

import com.gsmNetworking.user.domain.user.domain.User
import javax.persistence.*

/**
 * 멘토 정보를 저장하는 Entity 클래스 입니다.
 */
@Entity
@Table(name = "mentor")
class Mentor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val mentorId: Long,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
)