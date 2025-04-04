package services;

import models.Product;
import services.CartService;

public class CheckoutService {
    public void processCheckout(CartService cart) {
        double subtotal = 0;
        for (Product product : cart.getItems()) {
            subtotal += product.getPrice();
        }
        System.out.println("Subtotal: " + subtotal);
    }
}
