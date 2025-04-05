package models;

public class Electronic extends Product {
    public Electronic(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
