package org.example.LibraryInventory;

import org.example.BookManagement.BookManage;
import org.example.BookManagement.BookSearch;
import org.example.BookManagement.Books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements BookManage, BookSearch {

    public List<Books> libraryBooks;

    public Inventory() {
        this.libraryBooks = new ArrayList<>();
    }

    @Override
    public void addBook(Books book) {
        libraryBooks.add(book);
    }

    @Override
    public void removeBook(Books book) {
        libraryBooks.remove(book);
    }

    @Override
    public Books searchBookByISBN(String isbn) {
        for (Books book : libraryBooks) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }


    @Override
    public List<Books> searchBooksbyAuthor() {
        return List.of();
    }

    @Override
    public Books searchBookByTitle(String title){
        for (Books book : libraryBooks) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean ManageBookUnits(String isbn, UnitsManagement unitsleft) {
        Books book = searchBookByISBN(isbn);
        if (book != null) {
             unitsleft.ManageBookUnits(book);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "libraryBooks=" + libraryBooks +
                '}';
    }
}
