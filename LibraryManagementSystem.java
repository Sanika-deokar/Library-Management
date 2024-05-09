import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class representing a book entity
class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;

    public Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Library class containing methods to manage books
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Quantity: " + book.getQuantity());
        }
    }

    // Method to search for a book by title
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found - ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Quantity: " + book.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some initial books to the library
        library.addBook(new Book(1, "Java Programming", "John Doe", 5));
        library.addBook(new Book(2, "Python Programming", "Jane Smith", 3));
        library.addBook(new Book(3, "Database Management", "Alice Johnson", 7));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter book title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    //library.addBook(new Book(library.size() + 1, title, author, quantity));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    // Display all books
                    library.displayAllBooks();
                    break;
                case 3:
                    // Search for a book by title
                    System.out.print("Enter book title to search: ");
                    scanner.nextLine(); // Consume newline
                    String searchTitle = scanner.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
