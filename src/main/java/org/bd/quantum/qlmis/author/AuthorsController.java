package org.bd.quantum.qlmis.author;

import org.bd.quantum.qlmis.books.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorsController {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("authors")
    public List<Authors> getAllAuthor(){
        return authorsService.showAllAuthor();
    }

    @GetMapping("authors/{id}")
    public Authors getAuthorById(@PathVariable Long id ){
        return authorsService.showAuthorById(id);
    }

    @PostMapping("authors")
    public String createAuthor(@RequestBody Authors authors ){

        return authorsService.createAuthor(authors);
    }

    @DeleteMapping("authors/{id}")
    public String deleteAuthor(@PathVariable Long id ){
        if(authorsService.deleteAuthor(id)){
          return "Deleted Successfully";
      }
        return "Not Found";
    }

    @PutMapping("authors/{id}")
    public String updateAuthor (@PathVariable Long id, @RequestBody Authors authors ){
          return  authorsService.updateAuthor(id,authors);
      }
    }