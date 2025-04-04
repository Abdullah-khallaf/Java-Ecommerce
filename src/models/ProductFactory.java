package models;

public class ProductFactory {
    public static Product createProduct(String type, String name, double price, int quantity, boolean isExpired) {
        switch (type) {
            case "Food": return new Food(name, price, quantity, isExpired);
            case "Electronic": return new Electronic(name, price, quantity);
            default: throw new IllegalArgumentException("Unknown product type");
        }
    }
}
