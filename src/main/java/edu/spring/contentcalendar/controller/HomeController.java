package edu.spring.contentcalendar.controller;

import edu.spring.contentcalendar.config.ContentCalendarProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping
    public ContentCalendarProperties home() {
        return properties;
    }

//    @Value("${cc.welcomeMessage: Default Welcome Message}")
//    private String welcomeMessage;
//
//    @Value("${cc.about}")
//    private String about;
//
//    @GetMapping
//    public Map<String, String> home() {
//        return Map.of("welcomeMessage", welcomeMessage, "about", about);
//    }

}
