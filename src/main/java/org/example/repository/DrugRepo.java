package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DrugRepo {

    private static final String INSERT_QUERY = "insert into drug(name,price,numbers) values (?,?,?)";
    private static final String DELETE_QUERY = "DELETE FROM drug WHERE id= ?";
    private static final String QUERY = "SELECT * FROM drug";
    private static final String QUERY1 = "SELECT * FROM drug  where id = ?";

    public void createDrug(Drug drug) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, drug.getName());
            preparedStatement.setInt(2, drug.getPrice());
            preparedStatement.setInt(3,drug.getNumbers());



            preparedStatement.execute();
            System.out.println("Drug created Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Drug> deleteDrug(Drug drug) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, drug.getId());

            preparedStatement.execute();
            System.out.println("Drug deleted successfully.");

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    public ArrayList<Drug> table() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Drug> drugs = new ArrayList<>();
            while (resultSet.next()) {
                Drug drug = new Drug();
                drug.setId(resultSet.getInt("id"));
                drug.setName(resultSet.getString("name"));
                drug.setPrice(resultSet.getInt("price"));
                drug.setNumbers(resultSet.getInt("numbers"));


                drugs.add(drug);
            }
            resultSet.close();
            connection.close();
            return drugs;


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Drug findData(int drugId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);
            preparedStatement.setInt(1, drugId);
            ResultSet resultSet = preparedStatement.executeQuery();


            Drug drug = new Drug();
            while (resultSet.next()) {
                drug.setId(resultSet.getInt("id"));
                drug.setName(resultSet.getString("name"));
                drug.setPrice(resultSet.getInt("price"));
                drug.setNumbers(resultSet.getInt("numbers"));
            }

            preparedStatement.close();
            connection.close();

            return drug;

        } catch (
                SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Drug findData1() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();


            Drug drug = new Drug();
            while (resultSet.next()) {
                drug.setId(resultSet.getInt("id"));
                drug.setName(resultSet.getString("name"));
                drug.setPrice(resultSet.getInt("price"));
                drug.setNumbers(resultSet.getInt("numbers"));
            }

            preparedStatement.close();
            connection.close();

            return drug;

        } catch (
                SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
