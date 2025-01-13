package org.example.BookManagement;

import java.util.List;

public interface BookSearch {
    Books searchBookByISBN(String isbn);
    List<Books> searchBooksbyAuthor();
    Books searchBookByTitle(String title);
}
