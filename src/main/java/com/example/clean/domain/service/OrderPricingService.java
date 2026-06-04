package com.example.clean.domain.service;

import com.example.clean.domain.model.Order;

public class OrderPricingService {

    public double calculateTotal(Order order) {
        return order.getItems()
                .stream()
                .mapToDouble(item -> item.subtotal())
                .sum();
    }
}
