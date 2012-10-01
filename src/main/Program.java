package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";

    public static void main(String[] args) {
        while (true) {
            printMenu();

            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStream);
            int i1 = getUserChoice(reader);

            if (i1 == 1) {
                printBookCatalog();
            } else if (i1 == 2) {
                reserveBook(reader);
            } else if (i1 == 3) {
                checkLibraryNumber();
            } else if (i1 == 4) {
                printMovieCatalog();
            } else if (i1 == 5) {
                login(reader);

            } else if (i1 == 9) {
                quit();
                break;
            } else {
                wrongSelection();
            }
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
        System.out.println("\n");
        System.out.println("Enter a valid integer!!");
    }

    private static void quit() {
        System.out.println("Quitting...");
    }

    private static void login(BufferedReader reader) {
        clearLogin();
        System.out.println("Enter your library number");
            String libraryNumber = readLine(reader);
            if (validLibraryNumber(libraryNumber)) {
                    System.out.println("Enter your Password: ");
                    String password = readLine(reader);
                    if (validPassword(password)) {
                        loggedIn = true;
                        savedLibraryNumber = libraryNumber;
                    }
            }
    }

    private static String readLine(BufferedReader reader) {
        try{
            return reader.readLine();
        } catch(Exception e){
            return "";
        }

    }

    private static void printMovieCatalog() {
        System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
        System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
        System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
        System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
        System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(createMovie("Inception", "Frank Darabont", "10"));
        System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    private static void checkLibraryNumber() {
        if (loggedIn()) {
            System.out.println("\nYour library number is " + savedLibraryNumber);
        } else {
            System.out.println("\nPlease talk to Librarian. Thank you.");
        }
    }

    private static void reserveBook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int i2 =  getUserChoice(reader);
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

    private static int getUserChoice(BufferedReader reader) {
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

    private static boolean loggedIn() {
        return loggedIn;
    }


    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

