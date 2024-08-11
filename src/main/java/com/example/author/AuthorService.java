package com.example.author;

import com.example.author.model.Author;
import com.example.author.repo.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorService  {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository){
        this.repository = repository;
    }
    //read
    public List<Author> readAll(){
        return repository.findAll();
    }
    public Author readOne(Long id){
        return repository.findById(id).orElse(null);
    }
    //create
    public Author create(
            String name,
            Integer debutYear
    ){
        return repository.save(new Author(name,debutYear));
    }
    //update
    public Author update(
            Long id,
            String name,
            Integer debutYear
    ){
        Author author = repository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Article not found"));
        author.setName(name);
        author.setDebutYear(debutYear);

        return repository.save(author);
    }
    //delete
    public void delete(Long id){
        repository.deleteById(id);
    }
}
