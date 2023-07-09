package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.Cart;
import org.example.model.Drug;
import org.example.model.Noskhe;
import org.example.service.NoskheService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartRepo {

    private static final String INSERT_QUERY = "insert into cart(drug_id,noskhe_id) values (?,?)";
    private static final String QUERY = "SELECT * FROM cart where noskhe_id = ?";
    private static final String QUERY1 = "DELETE FROM cart WHERE id= ?";

    public void createCart(Cart cart) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, cart.getDrugs().getId());
            preparedStatement.setInt(2,cart.getNoskhe().getId());



            preparedStatement.execute();
            System.out.println("Your cart created Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<Cart> table1(int noskheId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, noskheId);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Cart> carts = new ArrayList<>();
            while (resultSet.next()) {
                DrugRepo drugRepo = new DrugRepo();
                NoskheRepo noskheRepo = new NoskheRepo();
                Cart cart = new Cart();
                Noskhe noskhe1 = noskheRepo.findNoskhe(noskheId);
                Noskhe noskhe = new Noskhe(noskheId);
                cart.setId(resultSet.getInt("id"));
                int drug = resultSet.getInt("drug_id");
                Drug drug1 = new Drug(drug);
                Drug drug2 = drugRepo.findData(drug);
                cart.setDrugs(drug1);
                cart.setDrugs(drug2);
                cart.setNoskhe(noskhe);
                cart.setNoskhe(noskhe1);


                carts.add(cart);
            }
            resultSet.close();
            connection.close();
            return carts;


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Cart> deleteCart(Cart cart) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);
            preparedStatement.setInt(1, cart.getId());

            preparedStatement.execute();
            System.out.println("Drug deleted successfully.");

            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
