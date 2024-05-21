package com.example.api.Controlllers;

import com.example.api.Entity.Book;
import com.example.api.Service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@RestController
public class BookController {

    BookService bookService=new BookService();
    @GetMapping("/books")
    public List<Book> getBooks() {
        List<Book> list =bookService.getAllBooks();
        return list;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){
        Book book=bookService.getBookById(id);
        return book;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book ){
        Book book1 = bookService.addBook(book);
        return book1;
    }
    
}
