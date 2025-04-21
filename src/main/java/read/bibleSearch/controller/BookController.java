    package read.bibleSearch.controller;


    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import read.bibleSearch.model.Books;
    import read.bibleSearch.repository.BookRepository;

    import java.util.List;

    @RestController
    @RequestMapping("/api/book")

    public class BookController {

        private final BookRepository bookRepository;

        public BookController(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @GetMapping("/all")
        public ResponseEntity<?> getAllBooks() {
            List<Books> books = bookRepository.findAll();
            if (books.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(books);
        }
    }
