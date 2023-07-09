package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.Drug;
import org.example.model.Noskhe;
import org.example.model.Patient;

import java.sql.*;
import java.util.ArrayList;

public class NoskheRepo {
    private static final String INSERT_QUERY = "insert into noskhe (patient_id) values (?)";
    private static final String SELECT_QUERY = "select * from noskhe inner join patient p on p.id = noskhe.patient_id where noskhe.id = ?";
    private static final String UPDATE_CONFIRM_QUERY = "update noskhe set confirm = ? where id = ?";
    private static final String UPDATE_QUERY = "update noskhe set totalprice = (totalprice + ?) where id = ?";
    private static final String UPDATE1 = "update noskhe set confirm = 'NO' where id = ?";
    private static final String DELETE_QUERY = "DELETE FROM noskhe WHERE id= ?";
    private static final String QUERY = "SELECT * FROM noskhe where (confirm) = ('NO')";



    public void createNoskhe(Noskhe noskhe) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1,noskhe.getPatient().getId());



            preparedStatement.execute();
            System.out.println("Noskhe created Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Noskhe findNoskhe(int noskheId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1, noskheId);
            ResultSet resultSet = preparedStatement.executeQuery();


            Noskhe noskhe1 = new Noskhe(noskheId);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int patient = resultSet.getInt("patient_id");
                String confirm = resultSet.getString("confirm");
                int totalPrice = resultSet.getInt("totalprice");
                Patient patient1 = new Patient(patient);
                return new Noskhe(id,patient1,confirm,totalPrice);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateConfirm(Noskhe noskhe, int confirm){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONFIRM_QUERY);

            if(confirm == 1)
                preparedStatement.setString(1, "Yes");
            else if (confirm == 2)
                preparedStatement.setString(1, "No");

            preparedStatement.setInt(2, noskhe.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Noskhe updateCart(int totalPrice ,  int id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1,totalPrice);
            preparedStatement.setInt(2, id);


            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Noskhe> deleteNoskhe(Noskhe noskhe) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, noskhe.getId());

            preparedStatement.execute();
            System.out.println("Noskhe deleted successfully.");

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public Noskhe updateNoskhe(int id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE1);
            preparedStatement.setInt(1, id);


            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Noskhe> table() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Noskhe> noskhes = new ArrayList<>();
            while (resultSet.next()) {
                Noskhe noskhe = new Noskhe();
                noskhe.setId(resultSet.getInt("id"));
                noskhe.setConfirm(resultSet.getString("confirm"));
                noskhes.add(noskhe);
            }
            resultSet.close();
            connection.close();
            return noskhes;


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public Noskhe findNoskhe1() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();


            Noskhe noskhe = new Noskhe();
            while (resultSet.next()) {
                noskhe.setId(resultSet.getInt("id"));
                noskhe.setPatient(resultSet.getInt("patient_id"));
                noskhe.setConfirm(resultSet.getString("confirm"));
                noskhe.setTotalPrice(resultSet.getInt("totalprice"));
            }

            preparedStatement.close();
            connection.close();

            return noskhe;

        } catch (
                SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    }
