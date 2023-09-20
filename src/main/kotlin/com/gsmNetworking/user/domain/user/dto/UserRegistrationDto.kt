package com.gsmNetworking.user.domain.user.dto

data class UserRegistrationDto(
    val name: String,
    val generation: Int,
    val phoneNumber: String,
    val email: String,
    val snsUrl: String?,
    val profileUrl: String?
)