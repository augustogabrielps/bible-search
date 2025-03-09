package read.bibleSearch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import read.bibleSearch.model.Verses;
import read.bibleSearch.repository.VerseRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/bible")
public class BibleController {

    private final VerseRepository repository;

    public BibleController(VerseRepository repository) {
        this.repository = repository;
    }

    // Search a specific verse
    @GetMapping("/{bookId}/{chapter}/{verse}")
    public Verses getVerse(@PathVariable int bookId, @PathVariable int chapter, @PathVariable int verse) {

        Optional<Verses> result = repository.findByBookIdAndChapterAndVerse(bookId, chapter, verse);

        System.out.println("Querying for book: " + bookId + ", chapter: " + chapter + ", verse: " + verse);
        System.out.println("Result found: " + result);

        return result.orElseThrow(() -> new RuntimeException("Verse not found"));
    }
}



