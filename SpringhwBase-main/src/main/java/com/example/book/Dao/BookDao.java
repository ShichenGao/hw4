package com.example.book.Dao;

import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
@Repository
public interface BookDao extends JpaRepository<Book, String> {

}