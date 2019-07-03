package com.example.simpleprofileapp;

import java.io.Serializable;

public class Profile implements Serializable {

    private String name, userName, password, description;

    Profile() {
    }

    public Profile(String name, String userName, String password, String description) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public void  setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "fullName='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
