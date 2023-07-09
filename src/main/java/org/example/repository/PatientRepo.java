package org.example.repository;

import org.example.model.Patient;
import org.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientRepo {
    private static final String INSERT_QUERY = "insert into patient(username,nationalcode) values (?,?)";
    private static final String SELECT_BY_PASSWORD_QUERY = "select * from patient where nationalcode=?";
    private static final String SELECT_QUERY = "select * from patient where (nationalcode=?)";


    public void createPatient(Patient patient) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, patient.getUsername());
            preparedStatement.setString(2, patient.getNationalcode());



            preparedStatement.execute();
            System.out.println("Your account created Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Patient findPatientByPassword(String inputnatioNalcode) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_PASSWORD_QUERY);
            preparedStatement.setString(1, inputnatioNalcode);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationalcode = resultSet.getString(3);
                return new Patient(id,username,nationalcode);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Patient findPatient(String inputNationalcode) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, inputNationalcode);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationalcode = resultSet.getString(3);
                return new Patient(id,username,nationalcode);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
