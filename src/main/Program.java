package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";

    public static void main(String[] args) {
        while (true) {
            printMenu();
            menuSelection();
        }
    }

    private static void menuSelection() {
        int i1 = getUserChoice();

        if (i1 == 1) {
            printBookCatalog();
        } else if (i1 == 2) {
            reserveBook();
        } else if (i1 == 3) {
            checkLibraryNumber();
        } else if (i1 == 4) {
            printMovieCatalog();
        } else if (i1 == 5) {
            login();

        } else if (i1 == 9) {
            System.out.println("Quitting...");
        } else {
            System.out.println("\n");
            System.out.println("Enter a valid integer!!");
        }
    }

    private static void printMenu() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private static void login() {
        clearLogin();
        BufferedReader reader = createBufferedReader();
        System.out.println("Enter your library number");
        try {
            String libraryNumber = reader.readLine();
            if (validLibraryNumber(libraryNumber)) {
                try {
                    System.out.println("Enter your Password: ");
                    String password = reader.readLine();
                    if (validPassword(password)) {
                        loggedIn = true;
                        savedLibraryNumber = libraryNumber;
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }
    }

    private static void printMovieCatalog() {
        System.out.println(new Movie("Rocky", "John G. Avildsen", "10"));
        System.out.println(new Movie("Rocky II", "John G. Avildsen", "9"));
        System.out.println(new Movie("Rocky III", "John G. Avildsen", "8"));
        System.out.println(new Movie("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(new Movie("Rocky V", "John G. Avildsen", "8"));
        System.out.println(new Movie("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(new Movie("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(new Movie("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(new Movie("Inception", "Frank Darabont", "10"));
        System.out.println(new Movie("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    private static void checkLibraryNumber() {
        if (loggedIn) {
            System.out.println("\nYour library number is " + savedLibraryNumber);
        } else {
            System.out.println("\nPlease talk to Librarian. Thank you.");
        }
    }

    private static BufferedReader createBufferedReader() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        return new BufferedReader(inputStream);
    }

    private static void reserveBook() {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int i2 =  getUserChoice();
        switch (i2) {
            case 1:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            case 2:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            case 3:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            case 4:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            default:
                System.out.println("\n");
                System.out.println("Sorry we don't have that book yet.");
        }
    }

    private static int getUserChoice() {
        BufferedReader reader = createBufferedReader();
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
            return 0;
        }
    }

    private static void printBookCatalog() {
        System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
        System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
        System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
        System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
    }

    private static boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private static boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }


    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

}

