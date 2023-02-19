package org.practice.testLearn.application;

import org.practice.testLearn.application.command.OrderProductCommand;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.OrderPort;
import org.practice.testLearn.domain.ProductPort;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(OrderProductCommand command) {
        var product = orderPort.getProductById(command.productId());
        Order order = new Order(product, command.quantity());

        orderPort.save(order);
    }

}
