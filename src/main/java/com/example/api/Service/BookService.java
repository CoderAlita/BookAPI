package com.example.api.Service;

import com.example.api.Entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    public static List<Book> books= new ArrayList<>();

    static {
        books.add(new Book(1,"Kavya","Reality of life"));
        books.add(new Book(2,"Adesh","Code with Python"));
        books.add(new Book(3,"Alita","Core Java"));
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id) {
        Book book=null;
        try{
        book =books.stream().filter(e -> e.getId() == id).findFirst().get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }


    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    public void deleteBook(int id){

        books =books.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

    public void update(Book book, int id){
        books =books.stream().map(e ->
        {if( e.getId() == id)
        {
            e.setName(book.getName());
            e.setAuthor(book.getAuthor());}
            return e;
        }).collect(Collectors.toList());


    }

}
