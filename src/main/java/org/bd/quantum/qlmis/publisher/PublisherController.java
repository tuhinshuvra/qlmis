package org.bd.quantum.qlmis.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService1) {
        this.publisherService = publisherService1;
    }

    @GetMapping("publishers")
    public List<Publishers> getAllPublisher(){
        return publisherService.showAllPublisher();
    }

    @GetMapping("publishers/{id}")
    public Publishers getPublisherById(@PathVariable Long id ){
        return publisherService.showPublisherById(id);
    }

    @PostMapping("publishers")
    public String createPublisher(@RequestBody Publishers publishers ){
        return publisherService.createPublisher(publishers);
    }

    @DeleteMapping("publishers/{id}")
    public String deletePublisher(@PathVariable Long id ){

        if(publisherService.deletePublisher(id)){
          return "Deleted Successfully";
      }
        return "Not Found";
    }

    @PutMapping("publishers/{id}")
    public String updateBook (@PathVariable Long id, @RequestBody Publishers publishers ){
          return  publisherService.updatePublisher(id,publishers);
      }
    }

