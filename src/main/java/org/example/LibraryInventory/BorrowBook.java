package org.example.LibraryInventory;

import org.example.BookManagement.Books;

public class BorrowBook implements UnitsManagement{
    @Override
    public void ManageBookUnits(Books book) {
        if (book.getUnits() > 0) {
            book.setUnits(book.getUnits() - 1);
        } else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is currently not available.");
        }
    }
}
