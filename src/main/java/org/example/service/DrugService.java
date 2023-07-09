package org.example.service;

import org.example.model.Drug;
import org.example.repository.DrugRepo;

import java.util.ArrayList;

public class DrugService {
    public void createDrug(String name, int price, int numbers) {
        DrugRepo drugRepo = new DrugRepo();
        Drug drug = new Drug(name, price,numbers);
        drugRepo.createDrug(drug);
    }
    public void addDrug(String name , int price, int numbers){
        DrugService drugService = new DrugService();
        drugService.createDrug(name,price,numbers);
    }
    public  void deleteDrug(int id) {
        DrugRepo drugRepo = new DrugRepo();
        Drug drug = new Drug(id);
        drugRepo.deleteDrug(drug);
    }

    public void showTable(){
        DrugRepo drugRepo = new DrugRepo();
        ArrayList<Drug> drugs = drugRepo.table();

        for (int i = 0; i <drugs.size() ; i++) {
            System.out.println(drugs.get(i));
        }
    }

}
