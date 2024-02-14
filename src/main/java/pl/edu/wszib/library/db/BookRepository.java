package pl.edu.wszib.library.db;

import pl.edu.wszib.library.App;
import pl.edu.wszib.library.book.Book;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Book> books = new ArrayList<>();

    public BookRepository(){
        this.books.add(new Book("Dzieci z Bullerbyn","Astrid Lindgren", 1234567890120L));
        this.books.add(new Book("Chłopi","Władysław Reymont", 1234567890121L));
        this.books.add(new Book("Pan Tadeusz","Adam Mickiewicz", 1234567890122L));
        this.books.add(new Book("Dziady","Adam Mickiewicz", 1234567890123L));
        this.books.add(new Book("Harry Potter","J.K. Rowling", 1234567890124L));
        this.books.add(new Book("Test expired book","test", 12345678L,
                LocalDate.now().minusDays(28),
                LocalDate.now().minusDays(14),true,"Test test"));
        this.books.add(new Book("Test rented book","test123", 1234L,
                LocalDate.now(),
                LocalDate.now().plusDays(14),true,"Jakub Test"));
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public boolean rent(long isbn){
        for(Book book : this.books){
            if(book.getIsbn() == isbn && !book.isRent()){
                System.out.println("Enter your fullname");
                String fullName = scanner.nextLine();
                book.setfullName(fullName);
                book.setRent(true);
                book.setStartDate(LocalDate.now());
                book.setEndDate(LocalDate.now().plusDays(14));
                return true;
            }
        }
        return false;
    }

    public boolean addBook(){
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter author: ");
        String author = scanner.nextLine();
        System.out.println("Enter ISBN: ");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        Book newBook = new Book(title,author,isbn);
        books.add(newBook);
        return books.contains(newBook);
    }

    public void saveBook(Book book){
        try {
            String sql = "INSERT INTO tbook (title, author, isbn, startDate, endDate, rent, fullname) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = App.connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setLong(3, book.getIsbn());
            if (book.getStartDate() != null) {
                preparedStatement.setDate(4, java.sql.Date.valueOf(book.getStartDate()));
            } else {
                preparedStatement.setNull(4, java.sql.Types.DATE);
            }
            if (book.getEndDate() != null) {
                preparedStatement.setDate(5, java.sql.Date.valueOf(book.getEndDate()));
            } else {
                preparedStatement.setNull(5, java.sql.Types.DATE);
            }
            preparedStatement.setBoolean(6, book.isRent());
            preparedStatement.setString(7, book.getfullName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
