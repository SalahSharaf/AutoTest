package com.example.android.androidtutorial2;

import android.graphics.Bitmap;

import java.util.ArrayList;


public class User {
    private String name;
    private String email;
    private String passowrd;
    private String phoneNumber;
    private Bitmap photo;
    private Boolean isAdmin;
    private ArrayList<Test> tests;

    public User(String name,String password,String email,boolean isAdmin){
        this.name=name;
        this.email=email;
        this.passowrd=password;
        this.isAdmin=isAdmin;
    }

    public Boolean getAdmin() {return isAdmin;}

    public ArrayList<Test> getTests() {return tests;}
    public void addTest(Test test){
        tests.add(test);
    }

    public void setTests(ArrayList<Test> tests) {this.tests = tests;}

    public void setAdmin(Boolean admin) {isAdmin = admin;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
}
