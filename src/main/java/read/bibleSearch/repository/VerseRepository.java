package read.bibleSearch.repository;

import read.bibleSearch.model.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerseRepository extends JpaRepository<Verse, Integer> {

    // Search for all verses from a specific chapter
    List<Verse> findByBookIdAndChapter(int bookId, int chapter);

    // Search for a specific verse by book, chapter and verse number
    public Optional <Verse> findByBookIdAndChapterAndVerse(int bookId, int chapter, int verse);

    //
}
