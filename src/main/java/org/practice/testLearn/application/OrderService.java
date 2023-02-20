package org.practice.testLearn.application;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.result.CreateOrderResult;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.OrderPort;
import org.practice.testLearn.presentation.request.CreateOrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderPort orderPort;

    @Transactional
    public CreateOrderResult createOrder(CreateOrderRequest request) {
        var product = orderPort.getProductById(request.productId());
        var order = new Order(product, request.quantity());
        orderPort.save(order);
        return new CreateOrderResult(product.getName(), product.getPrice(), request.quantity());
    }
}
