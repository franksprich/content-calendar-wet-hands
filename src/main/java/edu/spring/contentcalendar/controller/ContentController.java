package edu.spring.contentcalendar.controller;

import edu.spring.contentcalendar.model.Content;
import edu.spring.contentcalendar.repository.ContentCollectionRepository;
import edu.spring.contentcalendar.repository.ContentJdbcTemplateRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@RestController
@RequestMapping("/api/v1/content")
@CrossOrigin(
        allowCredentials = "true",
        origins = {"http://localhost:4200"},
        allowedHeaders = {"Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"},
        exposedHeaders = {"Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "File-Name"},
        methods = {GET, POST, PUT, PATCH, DELETE, OPTIONS},
        maxAge = 3600
)
public class ContentController {

//    private final ContentCollectionRepository repository;
    private final ContentJdbcTemplateRepository repository;

    public ContentController(
//            ContentCollectionRepository repository
            ContentJdbcTemplateRepository repository
    ) {
        this.repository = repository;
    }

    // CRUD: Create, Read, Update, Delete - filter | paging and sorting

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }

}
