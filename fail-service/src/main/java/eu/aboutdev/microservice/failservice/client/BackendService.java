package eu.aboutdev.microservice.failservice.client;

import eu.aboutdev.microservice.failservice.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "serverless-service", url = "serverless-service", configuration = FeignConfiguration.class)
public interface BackendService {
    @GetMapping("/retryCall/{eventId}")
    boolean retry(@PathVariable("eventId") String eventId);
}