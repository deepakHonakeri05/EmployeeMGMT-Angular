package com.example.employeeDB.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "email_id")
    private String emailId;

    public long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmailId() {
        return emailId;
    }

    public Employee() {
    }

    public Employee(long id, String fname, String lname, String emailId) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.emailId = emailId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
