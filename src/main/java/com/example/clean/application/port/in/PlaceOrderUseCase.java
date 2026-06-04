package com.example.clean.application.port.in;

import com.example.clean.application.dto.PlaceOrderCommand;
import com.example.clean.application.dto.PlaceOrderResult;

public interface PlaceOrderUseCase {
    PlaceOrderResult placeOrder(PlaceOrderCommand command);
}
