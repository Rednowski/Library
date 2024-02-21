package pl.edu.wszib.library.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.library.book.Book;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookRepositoryTest {

    @Test
    public void rentBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 12345L;

        boolean actual = bookRepository.rentBookLocal(isbn);

        Assertions.assertTrue(actual);
    }

    @Test
    public void errorRentBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 1L;

        boolean actual = bookRepository.rentBookLocal(isbn);

        Assertions.assertFalse(actual);
    }

    @Test
    public void returnBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 1234L;

        boolean actual = bookRepository.returnBookLocal(isbn);

        Assertions.assertTrue(actual);
    }

    @Test
    public void errorReturnBookLocalTest() {
        BookRepository bookRepository = new BookRepository();
        long isbn = 12345L;

        boolean actual = bookRepository.returnBookLocal(isbn);

        Assertions.assertFalse(actual);
    }

    @Test
    public void getBooksShouldReturnBooksFromList() {

        List<Book> testDatabase = new ArrayList<>();
        testDatabase.add(new Book("Test Book 1", "Author 1", 123456L, null, null, false, null));
        testDatabase.add(new Book("Test Book 2", "Author 2", 789012L, null, null, false, null));

        BookRepository bookRepository = new BookRepository(testDatabase);

        List<Book> result = bookRepository.getBooks();

        assertEquals(2, result.size());
        assertEquals("Test Book 1", result.get(0).getTitle());
        assertEquals("Test Book 2", result.get(1).getTitle());
    }

    @Test
    public void errorGetBooksShouldReturnBooksFromList() {

        List<Book> testDatabase = new ArrayList<>();
        testDatabase.add(new Book("Test Book 1", "Author 1", 123456L, null, null, false, null));
        testDatabase.add(new Book("Test Book 2", "Author 2", 789012L, null, null, false, null));

        BookRepository bookRepository = new BookRepository(testDatabase);

        List<Book> result = bookRepository.getBooks();

        assertEquals(2, result.size());
        assertNotEquals("Test Book 2", result.get(0).getTitle());
        assertNotEquals("Test Book 1", result.get(1).getTitle());
    }
}
