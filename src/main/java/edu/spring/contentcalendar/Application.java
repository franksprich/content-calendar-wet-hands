package edu.spring.contentcalendar;

import edu.spring.contentcalendar.config.ContentCalendarProperties;
import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.model.Status;
import edu.spring.contentcalendar.model.Type;
import edu.spring.contentcalendar.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return args -> {
            log.info("Hello {}", "You");
            // insert some data into the database
            Content item = new Content(
                    null,
                    "What's new in ChatGPT",
                    "Chattergut",
                    Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    null,
                    null
            );
            repository.save(item);
        };
    }

}
