package read.bibleSearch.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import read.bibleSearch.model.Verses;
import read.bibleSearch.repository.VerseRepository;
import org.springframework.data.domain.Pageable;
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
    public Verses getVerse(
            @PathVariable int bookId,
            @PathVariable int chapter,
            @PathVariable int verse) {
        Optional<Verses> result = repository.findByBookIdAndChapterAndVerse(bookId, chapter, verse);

        System.out.println("Querying for book: " + bookId + ", chapter: " + chapter + ", verse: " + verse);
        System.out.println("Result found: " + result);

        return result.orElseThrow(() -> new RuntimeException("Verse not found"));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByKeyWord(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        Page<Verses> results = repository.findByTextContainingIgnoreCase(query, pageable);

        if(results.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Verse not found");
        }

        return ResponseEntity.ok(results);
    }
}



