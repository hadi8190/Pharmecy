package org.example.model;

import java.util.ArrayList;

public class Patient {
    private int id;
    private String username;
    private String nationalcode;

    public Patient(int id) {
        this.id = id;
        this.username = username;
        this.nationalcode = nationalcode;
    }

    public Patient(String username, String nationalcode) {
        this.username = username;
        this.nationalcode = nationalcode;
    }

    public Patient(int id, String username, String nationalcode) {
        this.id = id;
        this.username = username;
        this.nationalcode = nationalcode;
    }
    public Patient(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNationalcode() {
        return nationalcode;
    }

    public void setnationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }
}
