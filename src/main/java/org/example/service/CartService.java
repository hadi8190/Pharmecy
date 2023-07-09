package org.example.service;

import org.example.model.Cart;
import org.example.model.Drug;
import org.example.model.Noskhe;
import org.example.repository.CartRepo;

public class CartService {
    public void createCard(Drug drug, Noskhe noskhe) {
        CartRepo cartRepo = new CartRepo();
        Cart cart = new Cart(drug,noskhe);
        cartRepo.createCart(cart);
    }
    public  void deleteCart(int id) {
        CartRepo cartRepo = new CartRepo();
        Cart cart = new Cart(id);
        cartRepo.deleteCart(cart);
    }
}
