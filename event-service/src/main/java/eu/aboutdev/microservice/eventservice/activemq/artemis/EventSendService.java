package eu.aboutdev.microservice.eventservice.activemq.artemis;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventSendService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbit.event.queue}")
    private String eventQueue;

    public void send(final String eventId) {
        rabbitTemplate.convertAndSend(eventQueue, eventId);
    }
}
