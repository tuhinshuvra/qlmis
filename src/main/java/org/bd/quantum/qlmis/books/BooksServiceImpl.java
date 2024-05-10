package org.bd.quantum.qlmis.books;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public String createBook(Books books1) {
        Books books = new Books();
        BeanUtils.copyProperties(books1, books);
        booksRepository.save(books);
        return "Book Saved Successfully";
    }

    @Override
    public List<Books> showAllBook() {
        List<Books> booksList= booksRepository.findAll();
        List<Books> booksArrayList = new ArrayList<>();

        for(Books booksEntity : booksList ){
            Books books = new Books();
            BeanUtils.copyProperties(booksEntity, books);
            booksArrayList.add(books);
        }
        return booksArrayList;
    }

    @Override
    public Books showBookById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteBook(long id) {
        booksRepository.deleteById(id);
        return true;
    }

    @Override
    public String updateBook(long id, Books books) {
        Books updateBook = booksRepository.findById(id).orElse(null);
        if (updateBook != null) {
            BeanUtils.copyProperties(books, updateBook);
            booksRepository.save(updateBook);
            return "Book Updated Successfully";
        } else {
            return "Book Not Found";
        }
    }
}