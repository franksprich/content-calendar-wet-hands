package edu.spring.contentcalendar.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
//@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record Content(
        @Id
        Integer id,
        @NotBlank
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {

    // Copy constructor
    private Content(Content original, Integer id) {
        this(id, original.title, original.description, original.status, original.contentType, original.dateCreated, LocalDateTime.now(), original.url);
    }

    // Copy method
    public Content withId(Integer id) {
        return new Content(this, id);
    }

}
