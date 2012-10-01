package main;

public class Program {
    private static String savedLibraryNumber = "";
    private static SystemConsole console = new SystemConsole();
    private static PrintBookCatalog bookCatalog = new PrintBookCatalog();
    private static ReserveBook reserve = new ReserveBook(console);
    private static User user;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            if (performUserSelection()) break;
        }
    }

    private static boolean performUserSelection() {
        int i1 = SystemConsole.readInt();
        if (i1 == 1) {
            bookCatalog.printBookCatalog();
        } else if (i1 == 2) {
            reserve.reserveBook();
        } else if (i1 == 3) {
            checkLibraryNumber();
        } else if (i1 == 4) {
            printMovieCatalog();
        } else if (i1 == 5) {
            login();

        } else if (i1 == 9) {
            quit();
            return true;
        } else {
            wrongSelection();
        }
        return false;
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

    private static void login() {
        clearLogin();
        System.out.println("Enter your library number");
            String libraryNumber = console.readLine();
            System.out.println("Enter your Password: ");
            String password = console.readLine();
                user = new User(libraryNumber,password);
                    if (user.validateUser()) {
                        savedLibraryNumber = libraryNumber;
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
        if ((user != null)&&(user.isLoggedIn())) {
            System.out.println("\nYour library number is " + savedLibraryNumber);
        } else {
            System.out.println("\nPlease talk to Librarian. Thank you.");
        }
    }

    private static void clearLogin() {
        savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

