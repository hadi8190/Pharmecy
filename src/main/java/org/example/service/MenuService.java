package org.example.service;

public class MenuService {

    public static void printMainMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. Login");
        System.out.println("\t 2. Register");
    }

    public static void printLoginMenu(){
        System.out.println("\tPress:");
        System.out.println("\t 1. Login for admin");
        System.out.println("\t 2. Login for patient");
    }

    public static void printRegisterMenu(){
        System.out.println("\tPress:");
        System.out.println("\t 1. Register for admin");
        System.out.println("\t 2. Register for patient");
    }
    public static void printDrugMenu(){
        System.out.println("\tPress:");
        System.out.println("\t1. Create drug");
        System.out.println("\t2. Delete drug");
        System.out.println("\t3. Show drugList");
        System.out.println("\t4. Confirm");
        System.out.println("\t5. Quit");
    }

    public static void printNoskheMenu(){
        System.out.println("\tPress:");
        System.out.println("\t1. Show noskhe");
        System.out.println("\t2. Show cart");
        System.out.println("\t3. create noskhe");
        System.out.println("\t4. Edit noskhe");
        System.out.println("\t5. quit");
    }

    public static void editNoskhe(){
        System.out.println("\tPress:");
        System.out.println("\t1. add drug");
        System.out.println("\t2. Delete");
        System.out.println("\t3. Quit");
    }
    public static void editNoskhe1(){
        System.out.println("\tPress:");
        System.out.println("\t1. Delete cart");
        System.out.println("\t2. Delete noskhe");
    }

}
