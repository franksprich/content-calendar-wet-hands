package edu.spring.contentcalendar.repository;

import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.model.Status;
import edu.spring.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Repository
public class ContentCollectionRepository implements MyContentRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    @Override
    public List<Content> findAll() {
        return contentList;
    }

    @Override
    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    @Override
    public void save(Content content) {
        OptionalInt indexOpt = IntStream.range(0, contentList.size())
                .filter(i -> contentList.get(i).id().equals(content.id()))
                .findFirst();
        if (indexOpt.isPresent()) {
            // update
            contentList.remove(indexOpt.getAsInt());
            contentList.add(indexOpt.getAsInt(), content.withId(indexOpt.getAsInt() + 1));
        } else {
            // insert
            contentList.add(content.withId(contentList.size() + 1));
        }
    }

    @PostConstruct
    private void init() {
        Content item = new Content(
                1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
                );
        contentList.add(item);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).count() == 1;
    }

    @Override
    public void deleteById(Integer id) {
        contentList.removeIf(content -> content.id().equals(id));
    }
}
