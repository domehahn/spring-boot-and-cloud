package eu.aboutdev.microservice.serverlessservice.event.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventListenerService {

    @RabbitListener(queues = {"q.event-queue"})
    public void onUserRegistration(final String eventId) {
        log.info("EventId Received: {}", eventId);
    }

    @Bean
    public Function<String, Boolean> retryCall() {
        return value -> true;
    }
}
