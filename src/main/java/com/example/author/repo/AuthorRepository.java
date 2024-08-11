package com.example.author.repo;

import com.example.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository
   extends JpaRepository<Author, Long>  { }
