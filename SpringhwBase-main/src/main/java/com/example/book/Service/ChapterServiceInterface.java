package com.example.book.Service;



import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;

import java.util.List;
import java.util.NoSuchElementException;

public interface ChapterServiceInterface {
    Chapter GetChapter(String bookname,String title);
    void CreateChapter(Chapter chapter, String bookname) ;
    List<Chapter> ListChapters(String bookname);
    void UpdateChapter(String name,String title, Chapter chapter) ;
    void DeleteChapter(String name,String title) throws NoSuchElementException;
}
