package pl.edu.wszib.library.gui;

import pl.edu.wszib.library.book.Book;
import pl.edu.wszib.library.user.User;

import java.time.LocalDate;
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

    public void listRentedBooks(ArrayList<Book> books){
        int counter = 0;
        for(Book book : books){
            if(book.isRent()){
                System.out.println(book);
                counter++;
            }
        }
        if(counter == 0) System.out.println("There are no rented books");
    }

    public void listExpiredBooks(ArrayList<Book> books){
        int counter = 0;
        for(Book book : books){
            if(book.getEndDate() != null && book.getStartDate() != null){
                if(book.getEndDate().isBefore(LocalDate.now()) && book.isRent()){
                    System.out.println(book);
                    counter++;
                }
            }
        }
        if(counter == 0) System.out.println("There are no expired books");
    }

    public void searchBooks(ArrayList<Book> books){
        int counter = 0;
        System.out.println("Enter title or author or isbn:");
        String text = scanner.nextLine();
        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(text.toLowerCase()) ||
            book.getAuthor().toLowerCase().contains(text.toLowerCase()) ||
            String.valueOf(book.getIsbn()).contains(text)){
                System.out.println(book);
                counter++;
            }
        }
        if(counter == 0) System.out.println("No books found");
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
