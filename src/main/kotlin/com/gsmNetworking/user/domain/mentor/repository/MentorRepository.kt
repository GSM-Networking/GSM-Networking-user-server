package com.gsmNetworking.user.domain.mentor.repository

import com.gsmNetworking.user.domain.mentor.domain.Mentor
import org.springframework.data.repository.CrudRepository

/**
 * Mentor Entity를 위한 Repository 인터페이스 입니다.
 */
interface MentorRepository: CrudRepository<Mentor, Long>