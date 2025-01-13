package org.example.LendingProcess;

import org.example.BookManagement.Books;
import org.example.LibraryInventory.BorrowBook;
import org.example.LibraryInventory.Inventory;
import org.example.LibraryInventory.ReturnBook;
import org.example.LibraryInventory.UnitsManagement;
import org.example.Patron.Patrons;

import java.awt.print.Book;


public class LendingSystem {
    private Inventory inventory;

    public LendingSystem(Inventory inventory) {
        this.inventory = inventory;
    }

    // Checkout a book
    public void  checkoutBook(Patrons patron, String isbn) {
        Books book = inventory.searchBookByISBN(isbn);
        if (book != null) {
            // Use the BorrowQuantityStrategy to decrement the quantity
            UnitsManagement borrowingBook = new BorrowBook();
            if (inventory.ManageBookUnits(isbn, borrowingBook)) {
                patron.borrowBook(book);
                System.out.println(patron.getName() + " has checked out: " + book);
            }
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    // Return a book
    public void returnBook(Patrons patron, String isbn) {
        Books book = inventory.searchBookByISBN(isbn);
        if (book != null && patron.getBorrowedBooks().contains(book)) {
            // Use the ReturnQuantityStrategy to increment the quantity
            UnitsManagement returningBook = new ReturnBook();
            if (inventory.ManageBookUnits(isbn, returningBook)) {
                patron.returnBook(book);
                System.out.println(patron.getName() + " has returned: " + book);
            }
        } else {
            System.out.println("This book is not in the borrowed list of " + patron.getName());
        }

    }

    @Override
    public String toString() {
        return "LendingSystem{" +
                "inventory=" + inventory +
                '}';
    }
}
