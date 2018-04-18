package com.micetr0.mock_DB;
import java.util.Scanner;

public class InitDatabase {

    /**
     * Code based from CS320 Lab 06
     * @param keyboard keyboard input from user to select database
     */
    public static void init(Scanner keyboard) {
        //TODO: Actually get input from user
//        System.out.println("Which Database? 0 = fake, 1 = real (unimplemented)");
        Integer which = 1;
                //= Integer.parseInt(keyboard.nextLine());

        if (which == 0) {
            DatabaseProvider.setInstance(new Mock_DB());
        } else if (which == 1) {
            DatabaseProvider.setInstance(new MySqlDB());
        } else {
            throw new IllegalArgumentException("Invalid choice: " + which);
        }
    }
}
