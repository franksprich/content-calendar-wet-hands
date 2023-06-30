package edu.spring.contentcalendar.repository;

import edu.spring.contentcalendar.model.Content;

import java.util.List;
import java.util.Optional;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
public interface MyContentRepository {
    List<Content> findAll();

    Optional<Content> findById(Integer id);

    void save(Content content);

    void deleteById(Integer id);
}
