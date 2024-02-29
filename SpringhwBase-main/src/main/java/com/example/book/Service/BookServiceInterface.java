package com.example.book.Service;

import com.example.book.Entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

public interface BookServiceInterface {
    Book GetBook(String name);
    Book CreateBook(Book book);
    List<Book> ListBooks();
    Book UpdateBook(String name, Book book);
    void DeleteBook(String name);
}
