package model;

import java.util.Objects;

public class Inventory {
    private final int productId;
    private int quantity;

    public Inventory(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return productId == inventory.productId && quantity == inventory.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
