package com.gsmNetworking.user.global.config

import com.gsmNetworking.user.global.security.encrypt.properties.EncryptProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(
    basePackageClasses = [
        EncryptProperties::class
    ]
)
class PropertiesScanConfig