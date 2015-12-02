package com.example.amasio.testapplication;

import java.io.Serializable;

/**
 * Created by paulhammond on 12/1/15.
 */
public class Job implements Serializable{

    private String title;
    private String description;
    private String prerequisites;
    private String major;
    private String location;
    private String contact;

    public Job(){
        this.setTitle("");
        this.setDescription("");
        this.setPrerequisites("");
        this.setMajor("");
        this.setLocation("");
        this.setContact("");
    }

    public Job(String title, String description, String prerequisites, String major, String location,
               String contact){
        this.setTitle(title);
        this.setDescription(description);
        this.setPrerequisites(prerequisites);
        this.setMajor(major);
        this.setLocation(location);
        this.setContact(contact);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}