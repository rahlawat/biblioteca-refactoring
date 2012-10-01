package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 10/1/12
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class SystemConsole {
    static String readLine() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        try{
            return reader.readLine();
        } catch(Exception e){
            return "";
        }

    }

    static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
            return 0;
        }

    }
}
