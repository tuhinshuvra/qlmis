package org.bd.quantum.qlmis.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("books")
    public List<Books> getAllBook(){
        return booksService.showAllBook();
    }

    @GetMapping("books/{id}")
    public Books getBookById(@PathVariable Long id ){
        return booksService.showBookById(id);
    }

    @PostMapping("books")
    public String createBook(@RequestBody Books employee ){
        return booksService.createBook(employee);
    }

    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable Long id ){

        if(booksService.deleteBook(id)){
          return "Deleted Successfully";
      }

        return "Not Found";
    }

    @PutMapping("books/{id}")
    public String updateBook (@PathVariable Long id, @RequestBody Books books ){
          return  booksService.updateBook(id,books);
      }

    }

