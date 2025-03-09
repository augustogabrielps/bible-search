package read.bibleSearch.repository;

import read.bibleSearch.model.Verses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerseRepository extends JpaRepository<Verses, Integer> {

    // Search for a specific verse by book, chapter and verse number
    public Optional<Verses> findByBookIdAndChapterAndVerse(int bookId, int chapter, int verse);
}
