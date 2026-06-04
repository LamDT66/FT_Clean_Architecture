package com.example.clean.adapter.in.web;

import com.example.clean.application.dto.PlaceOrderCommand;
import com.example.clean.application.dto.PlaceOrderResult;
import com.example.clean.application.port.in.PlaceOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;

    public OrderController(PlaceOrderUseCase placeOrderUseCase) {
        this.placeOrderUseCase = placeOrderUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlaceOrderResponse placeOrder(@RequestBody PlaceOrderRequest request) {

        PlaceOrderCommand command = new PlaceOrderCommand(
                request.getCustomerId(),
                request.getItems().stream()
                        .map(item -> new PlaceOrderCommand.OrderItemCommand(
                                item.getProductCode(),
                                item.getQuantity(),
                                item.getUnitPrice()
                        ))
                        .toList()
        );

        PlaceOrderResult result = placeOrderUseCase.placeOrder(command);

        return new PlaceOrderResponse(result.getOrderId(), result.getTotal());
    }
}
