package edu.spring.contentcalendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.stream.IntStream;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Slf4j
@Profile("prod")
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Hallo {}", "Du");
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }
    }
}
