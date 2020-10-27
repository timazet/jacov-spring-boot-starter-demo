package com.epam.demo.signature.starter.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.epam.demo.signature.starter")
@EnableConfigurationProperties(SignatureProperties.class)
@ConditionalOnProperty(value = "demo.signature.enabled", havingValue = "true", matchIfMissing = true)
public class SignatureAutoConfiguration {
}
