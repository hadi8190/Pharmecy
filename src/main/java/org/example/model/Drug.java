package org.example.model;

public class Drug  {
    private int id;
    private String name;
    private int price;
    private int numbers; // drug count in warehouse
    private Admin admin;

    public Drug() {

    }
    public Drug(String name, int price, int numbers) {
        this.name = name;
        this.price = price;
        this.numbers = numbers;
    }

    public Drug(String name, int price, int numbers, Admin admin) {
        this.name = name;
        this.price = price;
        this.numbers = numbers;
        this.admin = admin;
    }

    public Drug(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Drug(int id) {
        this.id = id;
    }
    public Drug(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", numbers=" + numbers +
                '}';
    }
}
