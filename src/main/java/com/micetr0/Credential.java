package com.micetr0;


public class Credential{

    private final String username;
    private final String password;

    /**
     * Custom class - openJDK does not have Pairs included
     * @param username The user's unique username as a String
     * @param password The password associated with given username
     */
    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
