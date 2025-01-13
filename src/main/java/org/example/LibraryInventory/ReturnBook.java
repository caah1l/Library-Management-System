package org.example.LibraryInventory;

import org.example.BookManagement.Books;

public class ReturnBook implements UnitsManagement {
    @Override
    public void ManageBookUnits(Books book) {
        book.setUnits(book.getUnits() + 1);
    }
}
