package com.example.book.Service;

import com.example.book.Dao.BookDao;
import com.example.book.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {
    private BookDao bookDao;

    @Autowired
    public BookService(BookDao thebookDao) {
        bookDao = thebookDao;
    }

    @Override
    public List<Book> ListBooks() {
      return bookDao.findAll();
    }

    @Override
    public Book GetBook(String name) {
        Optional<Book> result = bookDao.findById(name);


        Book thebook = null;

        if (result.isPresent()) {
            thebook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book - " + name);
        }

        return thebook;

    }

    @Transactional
    public void DeleteBook(String name)  {
        Optional<Book> result = bookDao.findById(name);
        if (result.isPresent()) {
            bookDao.deleteById(name);
        }
        else {
            throw new NoSuchElementException("book not exist");
        }
    }

    @Override
    @Transactional
    public Book UpdateBook(String name, Book book)  {
        Optional<Book> result = bookDao.findById(name);
        if (result.isPresent()) {
            return bookDao.save(book);
        }
        else {
            throw new NoSuchElementException("book not exist");
        }
    }

    @Override
    @Transactional
    public Book CreateBook(Book book)  {
        Optional<Book> result = bookDao.findById(book.getName());
        if (result.isPresent()) {
            throw new NoSuchElementException("book has already existed");
        }
        else {
            return bookDao.save(book);
        }
    }






}
