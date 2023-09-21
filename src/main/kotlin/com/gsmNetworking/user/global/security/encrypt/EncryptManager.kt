package com.gsmNetworking.user.global.security.encrypt

interface EncryptManager {

    fun encrypt(encryptString: String): String
    fun decrypt(decryptString: String): String

}