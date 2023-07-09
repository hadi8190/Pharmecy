package org.example.service;

import org.example.model.Patient;
import org.example.repository.PatientRepo;


import java.util.ArrayList;

public class PatientService {

    public static void createPatient(String username, String nationalcode) {
        PatientRepo patientRepo = new PatientRepo();
        Patient patient = new Patient(username, nationalcode);
        patientRepo.createPatient(patient);
    }
    private Patient loggedInUser = null;

    public boolean register(String username, String nationalcode) {
        PatientRepo patientRepo = new PatientRepo();
        if (patientRepo.findPatientByPassword(nationalcode) == null) {
            Patient patient = new Patient(username, nationalcode);
            patientRepo.createPatient(patient);
            System.out.println("Account Created Successfully!");
            return true;
        }
        System.out.println("You Signed up with this password Before!");
        return false;
    }

    public boolean login(String nationalcode) {
        PatientRepo patientRepo = new PatientRepo();
        Patient patient = patientRepo.findPatient(nationalcode);
        if (patient != null) {
            if (patient.getNationalcode().equals(nationalcode)){
                this.loggedInUser = patient;
                System.out.println(patient.getUsername()+" with [You: "+ nationalcode
                        + "] Logged in Successfully");
                return true;
            }
        }
        System.out.println("Password is Incorrect!");
        return false;
    }

}
