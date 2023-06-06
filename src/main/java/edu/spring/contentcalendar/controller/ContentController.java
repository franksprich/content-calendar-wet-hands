package edu.spring.contentcalendar.controller;

import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@RestController
@RequestMapping("/api/v1/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    // make a request and find all the pieces of content in the system
    @GetMapping
    public ResponseEntity<List<Content>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"))
        );
    }

    @PostMapping
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

    // CRUD: Create, Read, Update, Delete - filter | paging and sorting

}
