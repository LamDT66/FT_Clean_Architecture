package com.example.clean.application.service;

import com.example.clean.application.dto.PlaceOrderCommand;
import com.example.clean.application.dto.PlaceOrderResult;
import com.example.clean.application.port.in.PlaceOrderUseCase;
import com.example.clean.application.port.out.OrderRepository;
import com.example.clean.domain.model.Order;
import com.example.clean.domain.model.OrderItem;
import com.example.clean.domain.service.OrderPricingService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PlaceOrderService implements PlaceOrderUseCase {

    private final OrderRepository orderRepository;
    private final OrderPricingService orderPricingService;

    public PlaceOrderService(OrderRepository orderRepository,
                             OrderPricingService orderPricingService) {
        this.orderRepository = orderRepository;
        this.orderPricingService = orderPricingService;
    }

    @Override
    @Transactional
    public PlaceOrderResult placeOrder(PlaceOrderCommand command) {
        List<OrderItem> items = command.getItems()
                .stream()
                .map(it -> new OrderItem(
                        it.getProductCode(),
                        it.getQuantity(),
                        it.getUnitPrice()
                ))
                .toList();

        Order order = new Order(null, command.getCustomerId(), items, 0);

        double total = orderPricingService.calculateTotal(order);
        order.assignTotal(total);

        Order savedOrder = orderRepository.save(order);

        return new PlaceOrderResult(savedOrder.getId(), savedOrder.getTotal());
    }
}
