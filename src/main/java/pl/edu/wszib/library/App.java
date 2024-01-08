package pl.edu.wszib.library;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean run = true;
        while(run){
            System.out.println("1. List all books");
            System.out.println("2. List rented books");
            System.out.println("3. List expired rentals");
            System.out.println("4. Search book");
            System.out.println("5. Rent book");
            System.out.println("6. Add book");
            System.out.println("7. Exit");

            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();

            switch(choose){
                case "1":
                    System.out.println("listing all books");
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
                    System.out.println("Renting a book");
                    break;
                case "6":
                    System.out.println("Adding a book");
                    break;
                case "7":
                    run = false;
                    break;
                default:
                    System.out.println("Eror in choosing");
                    break;
            }
        }

    }
}
