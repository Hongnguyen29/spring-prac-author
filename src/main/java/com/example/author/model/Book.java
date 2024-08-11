package com.example.author.model;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;
    @Setter
    private String summary;
    @Setter
    private Integer rating;

    @Setter
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String title,
                String summary,
                Integer rating,
                Author author) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.author = author;

    }
}
