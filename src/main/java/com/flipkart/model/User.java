package com.flipkart.model;

public class User {

    private String phoneNumber;
    private String name;
    private String gender;
    private String pinCode;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public User(String name, String phoneNumber, String gender, String pinCode) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.gender = gender;
        this.pinCode = pinCode;
    }

    public User() {
    }
}
