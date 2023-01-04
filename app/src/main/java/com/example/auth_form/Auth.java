package com.example.auth_form;

import java.util.ArrayList;

public class Auth {

    Users regUsers = new Users();

    public boolean checkLogin(String username, String password) {
        if (username.equals(regUsers.getAdmin().getUsername()) && password.equals(regUsers.getAdmin().getPassword())) {
            return true;
        }

        ArrayList<User> users = regUsers.getUsers();

        for (User user : users) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().toLowerCase().equals(password.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public boolean Register(String username, String password) {


        if (username.equals(regUsers.getAdmin().getUsername())) {
            return false;
        }

        ArrayList<User> users = regUsers.getUsers();

        for (User user : users) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return false;
            }
        }

        //The desired username and password are avaliable:

        regUsers.addUser(username, password);
        return true;
    }

}
