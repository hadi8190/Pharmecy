package org.example.model;

public class Admin {
    private int id;
    private String username;
    private String nationalcode;

    public Admin(int id, String username, String nationalcode) {
        this.id = id;
        this.username = username;
        this.nationalcode = nationalcode;
    }

    public Admin(String username, String nationalcode) {
        this.username = username;
        this.nationalcode = nationalcode;
    }

    public Admin(int id) {
        this.id = id;
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

    public String getnationalcode() {
        return nationalcode;
    }

    public void setnationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }
}
