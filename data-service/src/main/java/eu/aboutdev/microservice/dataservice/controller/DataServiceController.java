package eu.aboutdev.microservice.dataservice.controller;

import eu.aboutdev.microservice.dataservice.model.Data;
import eu.aboutdev.microservice.dataservice.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DataServiceController {

    private final DataRepository dataRepository;

    @Cacheable(value = "events", key = "#eventId")
    @GetMapping("/data/{eventId}")
    public List<String> findByCustomerId(@PathVariable("eventId") Long eventId) {
        final Data data = Data.builder()
                .eventId(UUID.randomUUID().toString())
                .build();
        final Data save = dataRepository.save(data);
        return List.of(save.getEventId());
    }
}
