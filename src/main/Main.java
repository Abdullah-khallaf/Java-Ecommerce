package main;

import java.util.Scanner;
import java.util.ArrayList;
import models.Product;
import models.Food;
import models.Electronic;


public class Main {
    private static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-commerce System");

        while (true) {
            System.out.println("\nLogin as (1) Admin or (2) Customer or (3) Exit:");
            int role = scanner.nextInt();
            if (role == 1) {
                adminMenu(scanner);
            } else if (role == 2) {
                customerMenu(scanner);
            } else if (role == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid role selection.");
            }
        }

        scanner.close();
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addProduct(scanner);
                case 2 -> viewAllProducts();
                case 3 -> {
                    System.out.println("Exiting Admin Mode.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void customerMenu(Scanner scanner) {
        entities.Customer customer = createCustomer(scanner);
        services.CartService cart = new services.CartService(customer);

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add product to cart");
            System.out.println("2. View cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> cart.addProductToCart(scanner, productList);
                case 2 -> viewCart(cart);
                case 3 -> {
                    services.CheckoutService checkout = new services.CheckoutService();
                    checkout.processCheckout(cart);
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter product type (1 for Food, 2 for Electronic): ");
        int type = scanner.nextInt();

        Product product;

        if (type == 1) {
            System.out.print("Is the food expired? (true/false): ");
            boolean isExpired = scanner.nextBoolean();
            product = new Food(name, price, quantity, isExpired);
        } else if (type == 2) {
            product = new Electronic(name, price, quantity);
        } else {
            System.out.println("Invalid product type.");
            return;
        }
        productList.add(product);
        System.out.println("Product added successfully.");
    }

    private static void viewAllProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productList) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ") Quantity: " + product.getQuantity());
        }
    }
    private static void viewCart(services.CartService cart) {
        System.out.println("\nYour Cart:");
        if (cart.getCart().isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Product product : cart.getCart()) {
                System.out.println("- " + product.getName() + " (x" + product.getQuantity() + ") - Price: $" + product.getPrice());
            }
        }
    }
    private static entities.Customer createCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.next();
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        return new entities.Customer(name, balance);
    }
}


