package com.example.author.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private Integer debutYear;


    @Setter
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, Integer debutYear) {
        this.name = name;
        this.debutYear = debutYear;
    }
}
