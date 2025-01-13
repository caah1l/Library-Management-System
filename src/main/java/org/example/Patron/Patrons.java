package org.example.Patron;

import org.example.BookManagement.Books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Patrons {

    private String name;
    private String membershipId;
    private List<Books> borrowedBooks;

    public Patrons(String name, String membershipId) {
        this.name = name;
        this.membershipId = membershipId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Books book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Books book) {
        borrowedBooks.remove(book);
    }
}
