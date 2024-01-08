package pl.edu.wszib.library;

import pl.edu.wszib.library.db.BookRepository;
import pl.edu.wszib.library.gui.GUI;

public class App {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        GUI gui = new GUI();
        boolean run = true;
        while(run){
            switch(gui.showMenuAndRead()){
                case "1":
                    gui.listBooks(bookRepository.getBooks());
                    break;
                case "2":
                    System.out.println("listing all rented books");
                    break;
                case "3":
                    System.out.println("listing all expired rentals of books");
                    break;
                case "4":
                    System.out.println("Searching for a book");
                    break;
                case "5":
                    gui.showResult(bookRepository.rent(gui.readISBN()));
                    break;
                case "6":
                    System.out.println("Adding a book");
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
