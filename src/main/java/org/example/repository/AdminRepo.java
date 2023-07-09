package org.example.repository;

import org.example.model.Admin;
import org.example.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepo {
    private static final String INSERT_QUERY = "insert into adminn(username,nationalcode) values (?,?)";
    private static final String SELECT_BY_PASSWORD = "select * from adminn where nationalcode=?";
    private static final String SELECT_QUERY = "select * from adminn where (nationalcode=?)";

    public void createAdmin(Admin admin) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getnationalcode());



            preparedStatement.execute();
            System.out.println("Your account created Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public  Admin findAdminByPassword(String inputNationalcode) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_PASSWORD);
            preparedStatement.setString(1, inputNationalcode);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationalcode = resultSet.getString(3);
                return new Admin(id,username,nationalcode);
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

    public Admin findAdmin(String inputnatioNalcode) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, inputnatioNalcode);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt(1);
                String username = resultSet.getString(2);
                String nationalcode = resultSet.getString(3);
                return new Admin(id,username,nationalcode);
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
