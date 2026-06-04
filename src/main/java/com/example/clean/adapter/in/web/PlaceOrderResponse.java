package com.example.clean.adapter.in.web;

public class PlaceOrderResponse {

    private final Long orderId;
    private final double total;

    public PlaceOrderResponse(Long orderId, double total) {
        this.orderId = orderId;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getTotal() {
        return total;
    }
}
