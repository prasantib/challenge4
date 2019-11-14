package com.company;
public class User {
    public String userEmail;
    public String password;
    public String name;
    public int id;


    public User() {
    }

    public User(String userEmail, String password, String name, int id) {
        this.userEmail = userEmail;
        this.password = password;
        this.name = name;
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void logOut()
    {
        System.out.println("You are successfully logged out");
    }





}
