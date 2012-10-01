package main;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 10/1/12
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReserveBook {
    private SystemConsole console;

    public ReserveBook(SystemConsole console) {
        this.console = console;
    }

    static void reserveBook() {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int i2 =  SystemConsole.readInt();
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
}
