package com.gsmNetworking.user.domain.user.util

import com.gsmNetworking.user.global.security.encrypt.EncryptUtil
import org.springframework.stereotype.Component
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
@Component
class EncryptConverter(
    private val encryptUtil: EncryptUtil
): AttributeConverter<String, String> {

    override fun convertToDatabaseColumn(attribute: String?): String? {
        if (attribute == null) return null
        return encryptUtil.encrypt(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): String? {
        if (dbData == null) return null
        return encryptUtil.decrypt(dbData)
    }

}