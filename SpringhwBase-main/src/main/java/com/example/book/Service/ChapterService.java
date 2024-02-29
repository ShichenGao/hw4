package com.example.book.Service;


import com.example.book.Dao.BookDao;
import com.example.book.Dao.ChapterDao;

import com.example.book.Entity.Book;
import com.example.book.Entity.Chapter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ChapterService implements ChapterServiceInterface {
    private ChapterDao chapterDao;
    private BookDao bookdao;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ChapterService( BookDao thebookdao,ChapterDao thechapterDao) {
        chapterDao = thechapterDao;
        bookdao =thebookdao;
    }
    @Override
    public List<Chapter> ListChapters(String bookname) {

     return chapterDao.findByName(bookname);
    }
    @Override
    public Chapter GetChapter(String name,String title) {
        return chapterDao.findByNameAndTitle(name,title);

    }

    @Override
    @Transactional
    public void CreateChapter(Chapter chapter, String bookname) {

        Optional<Book> result = bookdao.findById(bookname);
        if (result.isPresent()) {
            Book book=result.get();
            Chapter tempchapter=new Chapter(book,chapter.getTitle(),chapter.getContent());
            entityManager.persist(tempchapter);
        }
        else {
            throw new NoSuchElementException("book did not  exist");
        }


    }



    @Override
    @Transactional
    public void UpdateChapter(String name,String title, Chapter chapter) {


        Chapter tempchapter =chapterDao.findByNameAndTitle(name,title);;

       tempchapter.setTitle(chapter.getTitle());
       tempchapter.setContent(chapter.getContent());
       chapterDao.save(tempchapter);


    }

    @Override
    @Transactional
    public void DeleteChapter(String name,String title) throws NoSuchElementException {
       Chapter result = chapterDao.findByNameAndTitle(name, title);
       if (result!=null) {
           entityManager.remove(result);

       }
        else {
            throw new NoSuchElementException("chapter does not exist");
      }
    }
}
