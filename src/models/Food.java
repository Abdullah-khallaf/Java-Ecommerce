

package models;

public class Food extends Product {
    private boolean isExpired;

    public Food(String name, double price, int quantity, boolean isExpired) {
        super(name, price, quantity);
        this.isExpired = isExpired;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
