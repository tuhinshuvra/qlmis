package org.bd.quantum.qlmis.books;

import java.util.List;

public interface BooksService {

    String createBook(Books books);

    List<Books> showAllBook();

    Books showBookById(Long id);

    boolean deleteBook(long id);

    String updateBook(long id, Books books);
}