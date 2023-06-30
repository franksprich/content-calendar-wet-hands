package edu.spring.contentcalendar.repository;

import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.model.Status;
import edu.spring.contentcalendar.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Repository
public class ContentJdbcTemplateRepository implements MyContentRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Content> findAll() {
        String sql = "SELECT * FROM Content";
        return jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
    }

    @Override
    public Optional<Content> findById(Integer id) {
        String sql = "SELECT * FROM Content WHERE id=?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow));
    }

    @Override
    public void save(Content content) {
        if (null == content.id()) {
            String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, url) VALUES (?, ?, ?, ?, NOW(), ?)";
            jdbcTemplate.update(sql, content.title(), content.desc(), content.status().name(), content.contentType().name(), content.url());
        } else {
            String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
            jdbcTemplate.update(sql, content.title(), content.desc(), content.status().name(), content.contentType().name(), content.url(), content.id());
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM Content WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("desc"),
                rs.getString("status") != null ? Status.valueOf(rs.getString("status")) : null,
                rs.getString("content_type") != null ? Type.valueOf(rs.getString("content_type")) : null,
                Optional.ofNullable(rs.getTimestamp("date_created")).map(Timestamp::toLocalDateTime).orElse(null),
                Optional.ofNullable(rs.getTimestamp("date_updated")).map(Timestamp::toLocalDateTime).orElse(null),
                rs.getString("url")
                );
    }


//    public List<Content> getAllContent() {
//        String sql = "SELECT * FROM Content";
//        return jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
//    }
//    public Content getContent(int id) {
//        String sql = "SELECT * FROM Content WHERE id=?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
//    }
//    public void createContent(String title, String desc, String status, String contentType, String url) {
//        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, url) VALUES (?, ?, ?, ?, NOW(), ?)";
//        jdbcTemplate.update(sql, title, desc, status, contentType, url);
//    }
//
//    public void updateContent(int id, String title, String desc, String status, String contentType, String url) {
//        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
//        jdbcTemplate.update(sql, title, desc, status, contentType, url, id);
//    }
//    public void deleteContent(int id) {
//        String sql = "DELETE FROM Content WHERE id=?";
//        jdbcTemplate.update(sql, id);
//    }

}
