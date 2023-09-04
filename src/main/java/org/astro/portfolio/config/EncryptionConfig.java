package org.astro.portfolio.config;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Value("${jasypt.encryptor.password}")
    private String encryptionPassword;

    @Bean("textEncryptor")
    public BasicTextEncryptor textEncryptor() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(encryptionPassword);
        return encryptor;
    }
}