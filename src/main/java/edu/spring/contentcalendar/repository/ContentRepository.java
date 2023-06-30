package edu.spring.contentcalendar.repository;

import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
        SELECT * FROM content
        WHERE status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);

}
