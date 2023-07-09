package org.example;

import org.example.model.*;
import org.example.repository.NoskheRepo;
import org.example.service.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        DrugService drugService = new DrugService();
        PatientService patientService = new PatientService();
        NoskheService noskheService = new NoskheService();
        CartService cartService = new CartService();
        MenuService.printMainMenu();
        Main main = new Main();


        boolean quit = false;
        boolean quit2 = false;
        boolean quit3 = false;
        boolean quit4 = false;
        boolean quit5 = false;
        boolean quit6 = false;
        boolean quit7 = false;
        boolean quit8 = false;

        while (!quit) {
            System.out.println("Please Enter your choice(0 for Main Menu): ");
            int choice = scanner.nextByte();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    MenuService.printMainMenu();
                    break;
                case 1:
                    while (!quit2) {
                        System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                        int choice2 = scanner.nextByte();
                        scanner.nextLine();
                        switch (choice2) {
                            case 0:
                                MenuService.printLoginMenu();
                                break;
                            case 1:
                                main.login();
                                quit4 = false;
                               while (!quit4) {
                                    System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                                    int choice4 = scanner.nextByte();
                                    scanner.nextLine();
                                    switch (choice4) {
                                        case 0:
                                            MenuService.printDrugMenu();
                                            break;
                                        case 1:
                                            System.out.println("Enter drug's name: ");
                                            String name = scanner.nextLine();
                                            System.out.println("Enter drug's price: ");
                                            int price = scanner.nextInt();
                                            System.out.println("Enter drug's number: ");
                                            int numbers = scanner.nextInt();
                                            drugService.addDrug(name, price, numbers);
                                            break;
                                        case 2:
                                            System.out.println("Enter drug id: ");
                                            int drug_id = scanner.nextInt();
                                            drugService.deleteDrug(drug_id);
                                            break;
                                        case 3:
                                            drugService.showTable();
                                            break;
                                        case 4:
                                            noskheService.showTable();
                                            System.out.println("Enter noskhe id: ");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Do you confirm this noskhe: 1.Yes  2.No ");
                                            int chosenStatus = scanner.nextInt();
                                            noskheService.changeConfirm1(id, chosenStatus);
                                            break;
                                        case 5:
                                            quit4 = true;
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Enter your nationalcode: ");
                                String nationalcode1 = scanner.nextLine();
                                patientService.login(nationalcode1);
                                quit5 = false;
                                while (!quit5) {
                                    System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                                    int choice4 = scanner.nextByte();
                                    scanner.nextLine();
                                    switch (choice4) {
                                        case 0:
                                            MenuService.printNoskheMenu();
                                            break;
                                        case 1:
                                            System.out.println("Enter your noskheId: ");
                                            int noskheid = scanner.nextInt();
                                            noskheService.showTable(noskheid);
                                            break;
                                        case 2:
                                            System.out.println("Enter noskhe id: ");
                                            int noskheId1 = scanner.nextInt();
                                            noskheService.showTable(noskheId1);
                                            break;
                                        case 3:
                                            System.out.println("Enter patientId: ");
                                            int patient = scanner.nextInt();
                                            Patient patient1 = new Patient(patient);
                                            noskheService.createNoskhe(patient1);
                                            break;
                                        case 4:
                                            MenuService menuService = new MenuService();
                                                menuService.editNoskhe();
                                                while (!quit7){
                                                    System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                                                    int choice5 = scanner.nextByte();
                                                    scanner.nextLine();
                                                    switch (choice5){
                                                        case 0:
                                                            MenuService.editNoskhe();
                                                            break;
                                                        case 1:
                                                            drugService.showTable();
                                                            while (!quit6) {
                                                                System.out.println("Enter drug Id: ");
                                                                int drugID = scanner.nextInt();
                                                                System.out.println("Enter your number: ");
                                                                int number2 = scanner.nextInt();
                                                                Drug foundedDrug = noskheService.findData(drugID);
                                                                if (number2 > foundedDrug.getNumbers()) {
                                                                    System.out.println("Sorry we don't have it.");
                                                                }
                                                                System.out.println("Enter noskhe id: ");
                                                                int noskheId = scanner.nextInt();
                                                                noskheService.plus(drugID,number2,noskheId );
                                                                System.out.println("Do you want contineu?: 1.NO  2.YES");
                                                                if (scanner.nextInt() == 1) {
                                                                    quit6 = true;
                                                                }
                                                                Drug drug = new Drug(drugID);
                                                                Noskhe noskhe = new Noskhe(noskheId);
                                                                cartService.createCard(drug, noskhe);
                                                                noskheService.updateNoskhe(noskheId);

                                                            }break;
                                                        case 2:
                                                            while (!quit8){
                                                                System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                                                                int choice10 = scanner.nextByte();
                                                                scanner.nextLine();
                                                                switch (choice10){
                                                                    case 0:
                                                                        MenuService.editNoskhe1();
                                                                        break;
                                                                    case 1:
                                                                        System.out.println("Enter cart id: ");
                                                                        int cartId = scanner.nextInt();
                                                                        cartService.deleteCart(cartId);
                                                                        System.out.println("Do you want contineu?: 1.NO  2.YES");
                                                                        if (scanner.nextInt() == 1) {
                                                                            quit8 = true;
                                                                        }break;
                                                                    case 2:
                                                                        System.out.println("Enter noskhe ID: ");
                                                                        int noskheID = scanner.nextInt();
                                                                        noskheService.deleteNoskhe(noskheID);
                                                                        break;
                                                                    case 3:
                                                                        quit8 = true;
                                                                        break;
                                                                }
                                                            }
                                                        case 3:
                                                            quit7 = true;
                                                            break;
                                                    }
                                                }break;
                                        case 5:
                                            quit5 = true;
                                            break;
                                    }

                                }
                        }
                    }
                    break;
                case 2:
                    while (!quit3) {
                        System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                        int choice3 = scanner.nextByte();
                        scanner.nextLine();
                        switch (choice3) {
                            case 0:
                                MenuService.printRegisterMenu();
                                break;
                            case 1:
                                System.out.println("Enter your name: ");
                                String username = scanner.nextLine();
                                System.out.println("Enter your nationalcode: ");
                                String nationalcode2 = scanner.nextLine();
                                adminService.register(username, nationalcode2);
                                break;
                            case 2:
                                System.out.println("Enter your name: ");
                                String username1 = scanner.nextLine();
                                System.out.println("Enter your nationalcode: ");
                                String nationalcode3 = scanner.nextLine();
                                patientService.register(username1, nationalcode3);

                        }

                    }
                    break;
            }}

    }



public void login(){
    AdminService adminService = new AdminService();
    System.out.println("Enter your nationalcode: ");
    String nationalcode = scanner.nextLine();
    adminService.login(nationalcode);
}
}