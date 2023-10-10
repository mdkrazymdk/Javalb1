import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + year;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

      
        library.addBook(new Book("Book1", "Author1", "1234567890", 2020));
        library.addBook(new Book("Book2", "Author2", "0987654321", 2019));
        library.addBook(new Book("Book3", "Author3", "1112223334", 2021));

  
        System.out.println("All Books in Library:");
        library.displayBooks();

   
        String searchTitle = "Book2";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("\nFound Book: " + foundBook);
        } else {
            System.out.println("\nBook not found with title: " + searchTitle);
        }

   
        String isbnToRemove = "0987654321";
        boolean removed = library.removeBookByIsbn(isbnToRemove);
        if (removed) {
            System.out.println("\nBook with ISBN " + isbnToRemove + " removed successfully.");
        } else {
            System.out.println("\nBook with ISBN " + isbnToRemove + " not found in the library.");
        }

    
        System.out.println("\nUpdated List of Books in Library:");
        library.displayBooks();
    }
}
