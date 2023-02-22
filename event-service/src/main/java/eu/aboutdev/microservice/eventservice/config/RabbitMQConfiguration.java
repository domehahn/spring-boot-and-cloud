package eu.aboutdev.microservice.eventservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue createUserRegistrationQueue() {
        return new Queue("q.event-queue");
    }
}