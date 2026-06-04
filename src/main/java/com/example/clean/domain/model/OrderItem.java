package com.example.clean.domain.model;

public class OrderItem {

    private final String productCode;
    private final int quantity;
    private final double unitPrice;

    public OrderItem(String productCode, int quantity, double unitPrice) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must not be negative");
        }

        this.productCode = productCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double subtotal() {
        return quantity * unitPrice;
    }
}
