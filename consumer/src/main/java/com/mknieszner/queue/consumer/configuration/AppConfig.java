package com.mknieszner.queue.consumer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.mknieszner.queue.consumer")
@Import({com.mknieszner.queue.consumer.configuration.MessagingConfiguration.class})
public class AppConfig {
}
