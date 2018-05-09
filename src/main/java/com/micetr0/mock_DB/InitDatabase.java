package com.micetr0.mock_DB;
import java.util.Scanner;

public class InitDatabase {

    /**
     * Code based from CS320 Lab 06
     * @param isFakeDatabase True selects fake database, real uses real database
     */
    public static void init(Boolean isFakeDatabase) {
        //TODO: Actually get input from user
//        System.out.println("Which Database? 0 = fake, 1 = real (unimplemented)");

                //= Integer.parseInt(keyboard.nextLine());

        if (isFakeDatabase) {
            DatabaseProvider.setInstance(new Mock_DB());
        } else {
            DatabaseProvider.setInstance(new MySqlDB());
        }
    }
}
