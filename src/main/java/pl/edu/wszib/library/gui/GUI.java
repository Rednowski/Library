package pl.edu.wszib.library.gui;

import pl.edu.wszib.library.book.Book;
import pl.edu.wszib.library.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    private final Scanner scanner = new Scanner(System.in);
    public String showMenuAndRead(){
        System.out.println("1. List all books");
        System.out.println("2. List rented books");
        System.out.println("3. List expired rentals");
        System.out.println("4. Search book");
        System.out.println("5. Rent book");
        System.out.println("6. Add book");
        System.out.println("7. Exit");

        return scanner.nextLine();
    }

    public void listBooks(ArrayList<Book> books){
        for(Book book : books){
            System.out.println(book);
        }
    }

    public long readISBN(){
        System.out.println("Enter ISBN:");
        long isbn = scanner.nextLong();
        scanner.nextLine();
        return isbn;
    }

    public void showResult(boolean result){
        if(result){
            System.out.println("success");
        } else System.out.println("fail");
    }

    public User readAuthData(){
        System.out.println("Login: ");
        String login = this.scanner.nextLine();
        System.out.println("Password");
        return new User(login, this.scanner.nextLine());
    }


}
