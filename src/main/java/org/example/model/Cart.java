package org.example.model;

public class Cart {
    private int id;
    private Drug drugs;
    private Noskhe noskhe;


    public Cart(int id, Drug drugs, Noskhe noskhe) {
        this.id = id;
        this.drugs = drugs;
        this.noskhe = noskhe;
    }

    public Cart(Drug drugs, Noskhe noskhe) {
        this.drugs = drugs;
        this.noskhe = noskhe;

    }
    public Cart(int id){
      this.id = id;
    }



public Cart(){

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drug getDrugs() {
        return drugs;
    }

    public void setDrugs(Drug drugs) {
        this.drugs = drugs;
    }

    public Noskhe getNoskhe() {
        return noskhe;
    }

    public void setNoskhe(Noskhe noskhe) {
        this.noskhe = noskhe;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "drugs=" + drugs.getName() +
                ", totalPrice=" + noskhe.getTotalPrice() +
                '}';
    }
}


