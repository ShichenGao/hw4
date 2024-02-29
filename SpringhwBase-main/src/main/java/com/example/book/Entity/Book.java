package com.example.book.Entity;

import lombok.Data;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;

    @OneToMany(mappedBy = "book",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Chapter> chapters;;


    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }



    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
