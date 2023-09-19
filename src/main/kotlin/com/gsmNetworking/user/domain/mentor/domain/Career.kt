package com.gsmNetworking.user.domain.mentor.domain

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.time.LocalDateTime
import javax.persistence.*

/**
 * 멘토의 경력을 저장하는 Entity 클래스 입니다.
 */
@Entity
@Table(name = "career")
class Career(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id", nullable = false)
    var careerId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    @Cascade(value = [CascadeType.DELETE]) // 멘토가 삭제될 시에 경력도 삭제 된다.
    val mentor: Mentor,

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