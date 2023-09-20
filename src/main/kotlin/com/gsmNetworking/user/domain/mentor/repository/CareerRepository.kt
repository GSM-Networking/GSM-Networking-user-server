package com.gsmNetworking.user.domain.mentor.repository

import com.gsmNetworking.user.domain.mentor.domain.Career
import org.springframework.data.repository.CrudRepository

interface CareerRepository: CrudRepository<Career, Long>