package com.example.clean.config;

import com.example.clean.application.port.in.PlaceOrderUseCase;
import com.example.clean.application.port.out.OrderRepository;
import com.example.clean.application.service.PlaceOrderService;
import com.example.clean.domain.service.OrderPricingService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderPricingService orderPricingService() {
        return new OrderPricingService();
    }

    @Bean
    public PlaceOrderUseCase placeOrderUseCase(OrderRepository orderRepository,
                                               OrderPricingService orderPricingService) {
        return new PlaceOrderService(orderRepository, orderPricingService);
    }
}

