package main;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 10/1/12
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    static boolean loggedIn = false;
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean validateUser(){
        loggedIn = ((libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d")) && ("bhaisahab".equals(password)));
        return loggedIn;
    }
    public boolean isLoggedIn()
    {
        return loggedIn;
    }

}
