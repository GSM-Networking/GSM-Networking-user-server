package com.gsmNetworking.user.domain.user.service

import com.gsmNetworking.user.domain.user.domain.User
import com.gsmNetworking.user.domain.user.dto.UserRegistrationDto
import com.gsmNetworking.user.domain.user.repository.UserRepository
import com.gsmNetworking.user.global.exception.ExpectedException
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class UserRegistrationService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    /**
     * 유저 정보를 저장하는 메서드
     * 데이터의 중복을 막기 위해 식별자인 핸드폰으로 검증을 한다.
     *
     * @return 저장된 user 엔티티
     */
    fun execute(dto: UserRegistrationDto): User {
        validateExistUserByPhoneNumber(dto.phoneNumber)
        val encodedPhoneNumber = passwordEncoder.encode(dto.phoneNumber)
        val user = User(
            name = dto.name,
            generation = dto.generation,
            email = dto.email,
            phoneNumber = encodedPhoneNumber,
            snsUrl = dto.snsUrl,
            profileUrl = dto.profileUrl
        )
        return userRepository.save(user)
    }

    private fun validateExistUserByPhoneNumber(phoneNumber: String) {
        if (userRepository.existsByPhoneNumber(phoneNumber))
            throw ExpectedException(HttpStatus.BAD_REQUEST, "이미 존재하는 핸드폰 번호를 가진 유저 입니다.")
    }

}