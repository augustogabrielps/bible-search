package read.bibleSearch.controller;

import org.springframework.web.bind.annotation.*;
import read.bibleSearch.model.Verse;
import read.bibleSearch.repository.VerseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bible")
public class BibleController {

    private final VerseRepository repository;

    public BibleController(VerseRepository repository) {
        this.repository = repository;
    }

    // Search all verses from a given chapter
    @GetMapping("/{bookId}/{chapter}")
    public List<Verse> getAllVerses(@PathVariable int bookId, @PathVariable int chapter) {
        return repository.findByBookIdAndChapter(bookId, chapter);
    }

    // Search a specific verse
    @GetMapping("/{bookId}/{chapter}/{verse}")
    public Verse getVerse(@PathVariable int bookId, @PathVariable int chapter, @PathVariable int verse) {
        Optional<Verse> result = repository.findByBookIdAndChapterAndVerse(bookId, chapter, verse);

        // Debugging: Print to console
        System.out.println("Querying for book: " + bookId + ", chapter: " + chapter + ", verse: " + verse);
        System.out.println("Result found: " + result);

        return result.orElseThrow(() -> new RuntimeException("Verse not found"));
    }
}
