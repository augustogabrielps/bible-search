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
    public ResponseEntity<?> getVerse(
            @PathVariable int bookId,
            @PathVariable int chapter,
            @PathVariable int verse) {

        System.out.println("Querying for book: " + bookId + ", chapter: " + chapter + ", verse: " + verse);

        Optional<Verses> result = repository.findByBookIdAndChapterAndVerse(bookId, chapter, verse);

        if (result.isPresent()) {
            System.out.println("✅ Verse found: " + result.get());
            return ResponseEntity.ok(result.get()); // Retorna o versículo encontrado (200 OK)
        } else {
            System.out.println("❌ Verse not found for: " + bookId + " " + chapter + ":" + verse);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Verse not found\"}");
        }
    }
}

