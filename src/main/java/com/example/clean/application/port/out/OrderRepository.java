package com.example.clean.application.port.out;

import com.example.clean.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);
}

