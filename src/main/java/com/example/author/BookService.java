package com.example.author;

import com.example.author.model.Author;
import com.example.author.model.Book;
import com.example.author.repo.AuthorRepository;
import com.example.author.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository repository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository repository){
        this.bookRepository = bookRepository;
        this.repository =repository;
    }
    //create
    public Book create(
            Long authorId,
            String title,
            String summary,
            Integer rating){
        Author author = repository.findById(authorId).orElseThrow();
        Book book = new Book(title,summary,rating,author);
        return bookRepository.save(book);
    }
   //read One
    public Book readOne(
            Long id,
            Long idAuthor
    ){
        Book book = bookRepository.findById(id).orElse(null);
        if(!book.getAuthor().getId().equals(idAuthor))
            throw new RuntimeException();
        return book;
    }
    //read Author
    public List<Book> readAuthor(
            Long idAuthor
    ){
        List<Book> books = bookRepository.findAll();
        for (Book book: books){
            if(!book.getAuthor().getId().equals(idAuthor)){
                books.remove(book);
            }
        }
        return books;
    }
    //update
    public void delete(
            Long authorId,
            Long id
    ){
       Author author =repository.findById(authorId).orElseThrow();
       bookRepository.deleteById(id);
    }
    public Book update(
            Long authorId,
            Long id,
            String title,
            String summary,
            Integer rating
    ){  List<Book> books = repository.findById(authorId).orElseThrow().getBooks();
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setSummary(summary);
        book.setRating(rating);
        bookRepository.save(book);
         return book;
    }





}
