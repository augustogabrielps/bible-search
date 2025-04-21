package read.bibleSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import read.bibleSearch.model.Books;

import java.util.List;

public interface BookRepository extends JpaRepository<Books, Integer> {

}
