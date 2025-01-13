package org.example;

import org.example.BookManagement.Books;
import org.example.LendingProcess.LendingSystem;
import org.example.LibraryInventory.Inventory;
import org.example.Patron.Patrons;


public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Inventory inventory = new Inventory();
        LendingSystem lendingSystem = new LendingSystem(inventory);

        // Create some sample books (with quantities)
        Books book1 = new Books("Harry Potter", "JK rowling", "123456789", 2000, 1);
        Books book2 = new Books("Java handbook", "oracle", "987654321", 2010, 2);
        Books book3 = new Books("spring handbook", "unknown", "192837465", 2020, 3);

        // Add books to the inventory
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);

        // Create patrons
        Patrons patron1 = new Patrons("MSD", "P1001");
        Patrons patron2 = new Patrons("Virat", "P1002");

        // Checkout books for the patrons
        lendingSystem.checkoutBook(patron1, "123456789");
        lendingSystem.checkoutBook(patron2, "987654321");

        // Try checking out a book that is not available
        lendingSystem.checkoutBook(patron1, "123456789");

        // Return books
        lendingSystem.returnBook(patron1, "123456789");
        lendingSystem.returnBook(patron2, "987654321");

        // Check the status of the inventory
        System.out.println(inventory);
        System.out.println(lendingSystem);

    }
}