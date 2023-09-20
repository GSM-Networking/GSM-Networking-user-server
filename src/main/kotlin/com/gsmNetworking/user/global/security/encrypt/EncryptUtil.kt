package com.gsmNetworking.user.global.security.encrypt

import com.gsmNetworking.user.global.security.encrypt.properties.EncryptProperties
import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class EncryptUtil(
    private val encryptProperties: EncryptProperties
) {

    fun encrypt(encryptString: String): String {
        val encryptedString = getCipherPkcs5(Cipher.ENCRYPT_MODE)
            .doFinal(encryptString.toByteArray())
        return String(Base64.getEncoder().encode(encryptedString))
    }

    fun decrypt(decryptString: String): String {
        val byteString = Base64.getDecoder().decode(decryptString.toByteArray())
        return String(getCipherPkcs5(Cipher.DECRYPT_MODE).doFinal(byteString))
    }

    fun getCipherPkcs5(cipherMode: Int): Cipher {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val secretKey = SecretKeySpec(encryptProperties.secretKey.toByteArray(), "AES")
        val iv = IvParameterSpec(encryptProperties.secretKey.substring(0, 16).toByteArray())
        cipher.init(cipherMode, secretKey, iv)
        return cipher
    }

}