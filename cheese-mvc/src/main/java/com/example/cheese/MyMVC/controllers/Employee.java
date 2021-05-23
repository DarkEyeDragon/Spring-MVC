package com.example.cheese.MyMVC.controllers;

public class Employee {

    // Variables (Private)
    private String employeeID;
    private String firstName;
    private String lastName;

    public Employee(String employeeID, String firstName, String lastName) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // Getters (Public)
    public String getEmployeeID() {
        return employeeID;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
