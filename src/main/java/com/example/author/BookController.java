package com.example.author;

import com.example.author.model.Author;
import com.example.author.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.function.IntToDoubleFunction;

@Controller
@RequestMapping("authors/{authorId}/books")
public class BookController {
    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService,
                          AuthorService authorService){
        this.bookService =bookService;
        this.authorService = authorService;
    }

    @PostMapping("create")
    public String create(
            @PathVariable("authorId")
            Long authorId,
            @RequestParam("title")
            String title,
            @RequestParam("summary")
            String summary,
            @RequestParam("rating")
            Integer rating
    ){
        bookService.create(authorId,title,summary,rating);
        return String.format("redirect:/authors/%d",authorId);

    }
    @GetMapping("{id}/delete")
    public String delete(
            @PathVariable("authorId")
            Long authorId,
            @PathVariable("id")
            Long id
    ){
        bookService.delete(authorId,id);
        return String.format("redirect:/authors/%d",authorId);
    }
    @PostMapping("{id}/update")
    public String update(
            @PathVariable("authorId")
            Long authorId,
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("summary")
            String summary,
            @RequestParam("rating")
            Integer rating

    ){ bookService.update(authorId, id, title, summary, rating);
        return String.format("redirect:/authors/%d",authorId);
    }



}
