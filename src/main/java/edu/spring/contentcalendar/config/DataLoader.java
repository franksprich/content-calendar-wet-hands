package edu.spring.contentcalendar.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Hallo {}", "Du");
    }
}
