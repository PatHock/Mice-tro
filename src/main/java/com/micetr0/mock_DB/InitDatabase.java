package com.micetr0.mock_DB;
import java.util.Scanner;

public class InitDatabase {

    /**
     * Code based from CS320 Lab 06
     * @param keyboard Scans for user input from keyboard
     */
    public static void init(Scanner keyboard) {
        System.out.print("Which database (0 = Fake it till you make it, 1 = Tomcat): ");
        int which = Integer.parseInt(keyboard.nextLine());
        if (which == 0) {
            DatabaseProvider.setInstance(new Mock_DB());
        } else if (which == 1) {
            throw new IllegalArgumentException("Tomcat is asleep. Come back later.");
            //DatabaseProvider.setInstance(new DerbyDatabase());
        } else {
            throw new IllegalArgumentException("Invalid choice: " + which);
        }
    }
}
