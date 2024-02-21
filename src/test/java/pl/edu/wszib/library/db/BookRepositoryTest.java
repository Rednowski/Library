package pl.edu.wszib.library.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
