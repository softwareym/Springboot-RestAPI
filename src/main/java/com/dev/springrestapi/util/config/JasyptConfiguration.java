package com.dev.springrestapi.util.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JasyptConfiguration {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPoolSize(1);
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
