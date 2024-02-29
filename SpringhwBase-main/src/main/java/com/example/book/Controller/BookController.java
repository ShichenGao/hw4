package com.example.book.Controller;

import com.example.book.Entity.Book;
import com.example.book.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/books")
class BookController implements BookControllerInterface {

    @Autowired
    BookServiceInterface bookService;



    @GetMapping("/list")
    public List<Book> ListBooks() {
        return bookService.ListBooks();
    }




    @GetMapping("/{name}")
    public Book GetBook(@PathVariable String name) {
        try{
            return bookService.GetBook(name);
        }catch (NoSuchElementException e) {
            return null;
        }
    }


    @DeleteMapping("/{name}")
    public ResponseEntity<String> DeleteBook(@PathVariable String name) {
        try {
            bookService.DeleteBook(name);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).body("book " + name + " not found");
        }
        return ResponseEntity.status(OK).build();
    }

    @PutMapping("{name}")
    public ResponseEntity<Book> UpdateBook(@PathVariable String name, @RequestBody Book book) {
        try {
            bookService.UpdateBook(name, book);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
        return ResponseEntity.status(OK).body(book);
    }



    @PostMapping("/addbook")
    public ResponseEntity<Book> CreateBook(@RequestBody Book book) {
        try {
            bookService.CreateBook(book);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(BAD_REQUEST).build();
        }
        return ResponseEntity.status(OK).body(book);
    }









}
