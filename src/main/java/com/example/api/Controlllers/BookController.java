package com.example.api.Controlllers;

import com.example.api.Entity.Book;
import com.example.api.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    BookService bookService=new BookService();
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list =bookService.getAllBooks();
        if (list.size() <= 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        Book book= book= bookService.getBookById(id);;
       if(book ==null)
           return ResponseEntity.notFound().build();

       return ResponseEntity.of(Optional.of(book));

    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book ){
        try {
            Book book1 = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(book1));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable("id") int id){

        try {
            bookService.update(book,id);
            return ResponseEntity.of(Optional.of(book));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
