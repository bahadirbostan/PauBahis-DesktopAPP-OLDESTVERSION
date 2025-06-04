package com.example.pb_01;

import java.util.Scanner;

public class User {
        private int id;
        private String name;
        private String email;
        private String telno;
        private boolean isAdmin;
        private int balance;


    public User(int id,String name,String email,String telno,boolean isAdmin,int balance){
        this.id = id;
        this.name = name;
        this.email = email;
        this.telno = telno;
        this.isAdmin = isAdmin;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelno() {
        return telno;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
}