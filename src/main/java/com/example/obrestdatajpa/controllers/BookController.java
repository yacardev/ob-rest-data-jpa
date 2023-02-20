package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.respositories.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //attributes
    private BookRepository bookRepository;

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    //Methods
    public BookController(BookRepository bookRespository) {
        this.bookRepository = bookRespository;
    }


    //CRUD sobre entidad

    //Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt = bookRepository.findById(id);

        if(bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
        //return bookOpt.orElse(null);
        //return bookOpt.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());

    }

    /**
     * Create Book
     * @param book
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book){
        if (book.getId() != null){
          log.warn("Trying to create a book with id");
          System.out.println("Trying to create a book with id");
          return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    /**
     * Update book by ID
     * @param book
     * @return
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null){
            log.warn("Trying to update a book without ID");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("Book ID does not exists");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    /**
     * Delete By Id
     * @param id
     * @return
     */
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("Book ID does not exist");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("Delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
