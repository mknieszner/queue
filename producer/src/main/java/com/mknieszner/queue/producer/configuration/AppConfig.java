package com.mknieszner.queue.producer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.mknieszner.queue")
@Import({com.mknieszner.queue.producer.configuration.MessagingConfiguration.class})
public class AppConfig {
}
