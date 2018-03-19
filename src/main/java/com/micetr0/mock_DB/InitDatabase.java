package com.micetr0.mock_DB;
import java.util.Scanner;

public class InitDatabase {

    /**
     * Code based from CS320 Lab 06
     * @param isUseFakeDatabase If true, uses fake db
     */
    public static void init(Boolean isUseFakeDatabase) {
        if (isUseFakeDatabase) {
            DatabaseProvider.setInstance(new Mock_DB());
        }
        else {
            throw new IllegalArgumentException("Tomcat is asleep. Come back later.");
        }
    }
}
