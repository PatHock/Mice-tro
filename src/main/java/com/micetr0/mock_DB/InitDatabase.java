package com.micetr0.mock_DB;
import java.util.Scanner;

public class InitDatabase {

    /**
     * Code based from CS320 Lab 06
     * @param keyboard keyboard input from user to select database
     */
    public static void init(Scanner keyboard) {

        System.out.println("Which Database? 0 = fake, 1 = real (unimplemented)");
        int which = Integer.parseInt(keyboard.nextLine());

        if (which == 0) {
            DatabaseProvider.setInstance(new Mock_DB());
        } else if (which == 1) {
            throw new UnsupportedOperationException("Tomcat is asleep. Come back later.");
        } else {
            throw new IllegalArgumentException("Invalid choice: " + which);
        }
    }
}
