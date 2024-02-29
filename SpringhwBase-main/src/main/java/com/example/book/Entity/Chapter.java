package com.example.book.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;



    @Column(name="title")
    private String title;




    @Column(name="content")
    private String content;

    @Column(name = "name", insertable = false, updatable = false)
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
    @JoinColumn(name="name")
    private Book book;

    public Chapter(Book book,String title, String content) {
        this.book=book;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Chapter() {

    }
}
