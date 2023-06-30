package edu.spring.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties(String welcomeMessage, String about) {
}
