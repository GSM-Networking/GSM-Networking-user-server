package com.gsmNetworking.user.domain.user.repository

import com.gsmNetworking.user.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>