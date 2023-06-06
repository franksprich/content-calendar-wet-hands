package edu.spring.contentcalendar.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
//@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record Content(
        Integer id,
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
