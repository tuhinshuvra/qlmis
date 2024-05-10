package org.bd.quantum.qlmis.author;

import java.util.List;

public interface AuthorsService {

    String createAuthor(Authors authors);

    List<Authors> showAllAuthor();

    Authors showAuthorById(Long id);

    boolean deleteAuthor(long id);

    String updateAuthor(long id, Authors authors);
}