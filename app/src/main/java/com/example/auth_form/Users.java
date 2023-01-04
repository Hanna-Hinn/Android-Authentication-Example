package com.example.auth_form;


import java.util.ArrayList;

public class Users {
    ArrayList<User> users = new ArrayList<>();

    public Users() {
        users.add(new User("hanna","12345"));
        users.add(new User("test","test"));
        users.add(new User("Hanna","test"));
    }

    public User getAdmin() {
        return new User("Admin","Admin");
    }


    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(String username,String password) {
        users.add(new User(username,password));
    }

}
