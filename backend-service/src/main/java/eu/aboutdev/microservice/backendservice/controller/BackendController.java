package eu.aboutdev.microservice.backendservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BackendController {

    @GetMapping("/backend/{eventId}")
    public boolean backend(@PathVariable("eventId") String eventId) {
        log.info("EventId is {}", eventId);
        return true;
    }
}
