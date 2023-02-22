package eu.aboutdev.microservice.serverlessservice.client;

import org.springframework.web.bind.annotation.PathVariable;

public interface BackendService {
    boolean justDoIt(@PathVariable("eventId") String eventId);
}