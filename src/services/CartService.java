
package services;

import models.Product;
import entities.Customer;
import java.util.ArrayList;
import java.util.Scanner;

public class CartService {
    private final Customer customer;
    private final ArrayList<Product> cart;

    public CartService(Customer customer) {
        this.customer = customer;
        this.cart = new ArrayList<>();
    }

    public void addProductToCart(Scanner scanner, ArrayList<Product> productList) {
        System.out.println("Enter product name:");
        String name = scanner.next();
        Product selectedProduct = null;
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                selectedProduct = product;
                break;
            }
        }
        if (selectedProduct == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        if (quantity <= 0 || quantity > selectedProduct.getQuantity()) {
            System.out.println("Invalid quantity.");
            return;
        }

        selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
        Product cartProduct = new Product(selectedProduct.getName(), selectedProduct.getPrice(), quantity);
        cart.add(cartProduct);
        System.out.println("Added to cart: " + cartProduct.getName() + " (x" + quantity + ")");
    }

    public ArrayList<Product> getCart() {
        return cart;
    }
}
