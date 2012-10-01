package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";
    private static PrintBookCatalog bookCatalog = new PrintBookCatalog();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            performSelection();
        }
    }

    private static void performSelection() {
        int i1 = getUserChoice();

        if (i1 == 1) {
            bookCatalog.printBookCatalog();
        } else if (i1 == 2) {
            reserveBook();
        } else if (i1 == 3) {
            checkLibraryNumber();
        } else if (i1 == 4) {
            printMovieCatalog();
        } else if (i1 == 5) {
            login();

        } else if (i1 == 9) {
            quit();
        } else {
            wrongSelection();
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

    private static void wrongSelection() {
        System.out.println("\nEnter a valid integer!!");
    }

    private static void quit() {
        System.out.println("Quitting...");
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
        System.out.println(new Movie("Rocky", "John G. Avildsen", "10").toString());
        System.out.println(new Movie("Rocky II", "John G. Avildsen", "9").toString());
        System.out.println(new Movie("Rocky III", "John G. Avildsen", "8").toString());
        System.out.println(new Movie("Rocky IV", "John G. Avildsen", "7").toString());
        System.out.println(new Movie("Rocky V", "John G. Avildsen", "8").toString());
        System.out.println(new Movie("Drainage", "Francisco Trindade", "N/A").toString());
        System.out.println(new Movie("The Shawshank Redemption", "Frank Darabont", "10").toString());
        System.out.println(new Movie("The Godfather", "Francis Ford Coppola", "7").toString());
        System.out.println(new Movie("Inception", "Frank Darabont", "10").toString());
        System.out.println(new Movie("Pulp Fiction", "Quentin Tarantino", "6").toString());
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

