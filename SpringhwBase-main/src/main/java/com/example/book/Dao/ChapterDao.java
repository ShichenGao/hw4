package com.example.book.Dao;

import com.example.book.Entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterDao extends JpaRepository<Chapter, Integer> {


    List<Chapter> findByName(String bookname);


    Chapter findByNameAndTitle(String name, String title);

    void deleteByTitleAndName(String name,String title);



}
