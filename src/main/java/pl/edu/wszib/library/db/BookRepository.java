package pl.edu.wszib.library.db;

import pl.edu.wszib.library.book.Book;

import java.lang.foreign.StructLayout;
import java.time.LocalDate;

public class BookRepository {
    private final Book[] books = new Book[5];

    public BookRepository(){
        this.books[0] = new Book("Dzieci z Bullerbyn","Astrid Lindgren", 1234567890120L);
        this.books[1] = new Book("Chłopi","Władysław Reymont", 1234567890121L);
        this.books[2] = new Book("Pan Tadeusz","Adam Mickiewicz", 1234567890122L);
        this.books[3] = new Book("Dziady","Adam Mickiewicz", 1234567890123L);
        this.books[4] = new Book("Harry Potter","J.K. Rowling", 1234567890124L);
    }

    public Book[] getBooks(){
        return books;
    }

    public boolean rent(long isbn){
        for(Book book : this.books){
            if(book.getIsbn() == isbn && !book.isRent()){
                book.setRent(true);
                book.setStartDate(LocalDate.now());
                book.setEndDate(LocalDate.now().plusDays(14));
                return true;
            }
        }
        return false;
    }
}
