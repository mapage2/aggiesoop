package com.example.amasio.testapplication;

import java.io.Serializable;

/**
 * Created by Amasio on 11/3/15.
 */
public class Student implements Serializable {

    private int bannerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double gpa;
    private String classification;
    private String major;



    public Student(){

        this.setBannerId(0);
        this.setFirstName("");
        this.setLastName("");
        this.setEmail("");
        this.setPassword("");
        this.setGpa(0.0);
        this.setClassification("");
        this.setMajor("");
    }

    public Student(int bannerId, String firstName, String lastName, String email, String password, double gpa,
                   String classification, String major){

        this.setBannerId(bannerId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPassword(password);
        this.setGpa(gpa);
        this.setClassification(classification);
        this.setMajor(major);
    }

    public Student(int bannerId, String firstName, String lastName, String email, double gpa,
                   String classification, String major){

        this.setBannerId(bannerId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setGpa(gpa);
        this.setClassification(classification);
        this.setMajor(major);
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }



}
