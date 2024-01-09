package pl.edu.wszib.library;

import pl.edu.wszib.library.authorization.Authenticator;
import pl.edu.wszib.library.db.BookRepository;
import pl.edu.wszib.library.gui.GUI;
import pl.edu.wszib.library.user.User;

public class App {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        Authenticator authenticator = new Authenticator();
        GUI gui = new GUI();
        boolean run = false;
        int counter = 0;

        while(!run && counter < 3){
            User user = gui.readAuthData();
            run = authenticator.authenticate(user.getLogin(), user.getPassword());
            counter++;
        }

        while(run){
            switch(gui.showMenuAndRead()){
                case "1":
                    gui.listBooks(bookRepository.getBooks());
                    break;
                case "2":
                    System.out.println("listing all rented books");
                    gui.listRentedBooks(bookRepository.getBooks());
                    break;
                case "3":
                    System.out.println("listing all expired rentals of books");
                    gui.listExpiredBooks(bookRepository.getBooks());
                    break;
                case "4":
                    System.out.println("Searching for a book");
                    gui.searchBooks(bookRepository.getBooks());
                    break;
                case "5":
                    gui.showResult(bookRepository.rent(gui.readISBN()));
                    break;
                case "6":
                    System.out.println("Adding a book");
                    gui.showResult(bookRepository.addBook());
                    break;
                case "7":
                    run = false;
                    break;
                default:
                    System.out.println("Error in choosing");
                    break;
            }
        }

    }
}
