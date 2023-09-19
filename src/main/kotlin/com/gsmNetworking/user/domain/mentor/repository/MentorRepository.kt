package com.gsmNetworking.user.domain.mentor.repository

import com.gsmNetworking.user.domain.mentor.domain.Mentor
import org.springframework.data.repository.CrudRepository

interface MentorRepository: CrudRepository<Mentor, Long>