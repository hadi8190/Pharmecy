package org.example.service;

import org.example.model.Admin;
import org.example.repository.AdminRepo;

public class AdminService {
    private static Admin loggedInUser = null;

    public boolean register(String username, String nationalcode) {
        AdminRepo adminRepo = new AdminRepo();
        if (adminRepo.findAdminByPassword(nationalcode) == null) {
            Admin admin = new Admin(username,nationalcode);
            adminRepo.createAdmin(admin);
            System.out.println("Account Created Successfully!");
            return true;
        }
        System.out.println("You Signed up with this password Before!");
        return false;
    }

    public boolean login(String nationalcode) {
        AdminRepo adminRepo = new AdminRepo();
        Admin admin = adminRepo.findAdmin(nationalcode);
        if (admin != null) {
            if (admin.getnationalcode().equals(nationalcode)){
                this.loggedInUser = admin;
                System.out.println(admin.getUsername()+" with [YOU: "+ nationalcode
                        + "] Logged in Successfully");
                return true;
            }
        }
        System.out.println("Password is Incorrect!");
        return false;
    }

}
