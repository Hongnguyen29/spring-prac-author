package com.example.author;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service){
        this.service = service;
    }

    @GetMapping("home")
    public String readAll(Model model){
        model.addAttribute("authors",service.readAll());
        return "home.html";
    }
    @GetMapping({"{id}"})
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model){
        model.addAttribute("author",service.readOne(id));
        return "read.html";

    }
    @GetMapping("create")
    public String createView(){
        return "create.html";
    }
    @PostMapping("create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("debutYear")
            Integer debutYear
    ){
        service.create(name, debutYear);
        return "redirect:/authors/home";
    }
    @GetMapping("{id}/update")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ){
        model.addAttribute(
                "author",service.readOne(id));
        return "update.html";
    }
    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("name")
            String name,
            @RequestParam("debutYear")
            Integer debutYear){
        service.update(id, name, debutYear);
        return String.format("redirect:/authors/%d",id);
    }
    @GetMapping("{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id
    ){
        service.delete(id);
        return "redirect:/authors/home";
    }


}
