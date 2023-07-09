package org.example.service;

import org.example.model.*;
import org.example.repository.CartRepo;
import org.example.repository.DrugRepo;
import org.example.repository.NoskheRepo;

import java.util.ArrayList;

public class NoskheService {

    public void createNoskhe(Patient patient) {
        NoskheRepo noskheRepo = new NoskheRepo();
        Noskhe noskhe = new Noskhe(patient);
        noskheRepo.createNoskhe(noskhe);
    }

    public void showTable(int noskheId){
        CartRepo cartRepo = new CartRepo();
        ArrayList<Cart> carts = cartRepo.table1(noskheId);

        for (int i = 0; i <carts.size() ; i++) {
            System.out.println(carts.get(i));
        }
    }

    public void changeConfirm(int noskheId, int confirm) {
        NoskheRepo noskheRepo = new NoskheRepo();
        Noskhe noskhe = noskheRepo.findNoskhe(noskheId);
        noskhe.setId(noskheId);
        if (noskhe != null) {
            if (confirm == 1) {
                noskhe.setConfirm("Yes");
                noskheRepo.updateConfirm(noskhe, 1);
                System.out.println("Confirm Changed to 'Yes'");
            } else
                System.out.println("Confirm is Already 'Yes'!");
        } else if (confirm == 2) {
            noskhe.setConfirm("No");
            noskheRepo.updateConfirm(noskhe, 2);
            System.out.println("Confirm Changed to 'No'");
        } else {
            System.out.println("Confirm is Already 'No'!");
        }
    }

    public Drug findData(int drugId){
        DrugRepo drugRepo = new DrugRepo();
        Drug drug = drugRepo.findData(drugId);

        return drug;
    }

    public void changeConfirm1(int noskheId,int confirm) {
        NoskheService noskheService = new NoskheService();
            noskheService.changeConfirm(noskheId, confirm);
    }

    public void updatetotalPrice(int totalPrice , int Id) {
        NoskheRepo noskheRepo = new NoskheRepo();
        noskheRepo.updateCart(totalPrice,Id);
    }

    public void plus(int drugId, int number , int id){
        NoskheService noskheService = new NoskheService();
        DrugRepo drugRepo = new DrugRepo();
        Drug price = drugRepo.findData(drugId);
        number = number * price.getPrice();
        noskheService.updatetotalPrice(number,id);
    }
    public void updateNoskhe(int id){
        NoskheRepo noskheRepo = new NoskheRepo();
        noskheRepo.updateNoskhe(id);
    }

    public  void deleteNoskhe(int id) {
        NoskheRepo noskheRepo = new NoskheRepo();
        Noskhe noskhe = new Noskhe(id);
        noskheRepo.deleteNoskhe(noskhe);
    }
    public void showTable(){
        NoskheRepo noskheRepo = new NoskheRepo();
        ArrayList<Noskhe> noskhes = noskheRepo.table();

        for (int i = 0; i <noskhes.size() ; i++) {
            System.out.println(noskhes.get(i));
        }
    }
}
