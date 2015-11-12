package com.example.amasio.testapplication;

/**
 * Created by Amasio on 11/3/15.
 */
public class Student {

    private String firstName;
    private String lastName;
    private double gpa;
    private String major;
    private String email;
    private int bannerId;

    public Student(){

        this.setFirstName("yes");
        this.setLastName("");
        this.setGpa(0.0);
        this.setMajor("");
        this.setEmail("");
        this.setBannerId(0);
    }

    public Student(String firstName, String lastName, double gpa, String major, String email, int bannerId){

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGpa(gpa);
        this.setMajor(major);
        this.setEmail(email);
        this.setBannerId(bannerId);
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }
}
