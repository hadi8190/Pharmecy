package org.example.model;

import java.util.ArrayList;

public class Noskhe {
    private int id;
    private Patient patient;
    private String confirm;
    private int totalPrice;


    public Noskhe(int id) {
        this.id = id;
    }



    public Noskhe(int id, Patient patient, String confirm, int totalPrice) {
        this.id = id;
        this.patient = patient;
        this.confirm = confirm;
        this.totalPrice = totalPrice;
    }

    public Noskhe(int id, Patient patient, String confirm) {
        this.id = id;
        this.patient = patient;
        this.confirm = confirm;
    }


    public Noskhe(Patient patient) {
        this.patient = patient;
        this.confirm = "NO";
    }
    public Noskhe(){
        
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setCart(int cartId) {
    }

    public void setPatient(int patientId) {
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Noskhe{" +
                "id=" + id +
                ", confirm='" + confirm + '\'' +
                ", totalPrice'" + totalPrice + '\'' +
                '}';
    }
}
