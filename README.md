# Library Management System
This is a simple Java-based Library Management System that allows librarians to manage books, patrons, and the lending process efficiently. The system uses Object-Oriented Programming (OOP) principles and adheres to SOLID design principles.

## Features
## Book Management:
Add, remove, and search for books in the library inventory.<br>
Books have attributes like title, author, ISBN, year of publication, and quantity.

## Patron Management:
Patrons can borrow and return books.<br>
The system tracks the borrowing history of patrons.

## Lending Process:
Borrowing a book decreases its quantity.<br>
Returning a book increases its quantity.<br>
If a book's quantity is 0, it cannot be borrowed.

## Quantity Management:
Books have a quantity, and the system ensures that the quantity is managed correctly during borrowing and returning processes.<br>

## Strategy Pattern:
Quantity management (borrowing/returning books) is handled through the Strategy Pattern to allow for flexibility and extensibility.

# Project Structure
**Books :** Represents a book with properties such as title, author, ISBN, year of publication, and quantity.<br>
**Patron :** Represents a library patron with a name, ID, and a list of borrowed books.<br>
**Inventory :** Manages the collection of books, allowing for adding, removing, and searching for books. It also manages book quantities using strategies.<br>
**LendingSystem :** Handles the process of checking out and returning books by patrons, interacting with the Inventory.<br>
**UnitsManagment :** Interface for strategies that manage book quantities (either borrowing or returning).<br>
**CheckoutBook & ReturnBook :** Implementations of the **UnitsManagement** for borrowing and returning books, respectively.<br>

# Class Diagram 

                      +-------------------------+
                      |         Books            |
                      +-------------------------+
                      | - title: String         |
                      | - author: String        |
                      | - isbn: String          |
                      | - year: int             |
                      | - quantity: int         |
                      +-------------------------+
                      | + getTitle(): String    |
                      | + getAuthor(): String   |
                      | + getIsbn(): String     |
                      | + getYear(): int        |
                      | + getQuantity(): int    |
                      | + setQuantity(int)      |
                      +-----------+-------------+
                                  |
                                  | "has-a"
                                  |
                      +--------------------------+
                      |        Patrons           |
                      +-------------------------+
                      | - name: String          |
                      | - patronId: String      |
                      | - borrowedBooks: List<Book> |
                      +-------------------------+
                      | + borrowBook(Book)      |
                      | + returnBook(Book)      |
                      | + getBorrowedBooks(): List<Book> |
                      +-------------------------+
                                  |
                                  | "has-a"
                                  |
                      +-------------------------+
                      |       Inventory         |
                      +-------------------------+
                      | - books: List<Books>     |
                      +-------------------------+
                      | + addBook(Books)         |
                      | + removeBook(Books)      |
                      | + searchBookByIsbn(String) |
                      | + searchBookByTitle(String) |
                      | + manageQuantity(String, QuantityManagementStrategy) |
                      +-------------------------+
                                  |
                                  | "has-a"
                                  |
                      +-------------------------+
                      |     LendingSystem       |
                      +-------------------------+
                      | - inventory: Inventory  |
                      +-------------------------+
                      | + checkoutBook(Patrons, String) |
                      | + returnBook(Patrons, String)    |
                      +-------------------------+
                                  |
                                  | "uses"
                                  |
                    +-----------------------------+
                    |      UnitsManagement        |
                    +-----------------------------+
                    | + ManageBookUnits(Books): void |
                    +-----------------------------+
                                 ^
                                 |
                    +-----------------------------+
                    |       checkoutBook          |
                    +-----------------------------+
                    | + ManageBookUnits(Books): void |
                    +-----------------------------+
                                 ^
                                 |
                    +-----------------------------+
                    |        ReturnBook           |
                    +-----------------------------+
                    | + ManageBookUnits(Books): void |
                    +-----------------------------+

## How to Run
Clone the repository or download the project.<br>
Compile and run the Main class to test the system.<br>
Add, borrow, return, and search for books.
