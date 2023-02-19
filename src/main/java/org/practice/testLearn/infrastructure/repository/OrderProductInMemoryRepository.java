package org.practice.testLearn.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.OrderPort;
import org.practice.testLearn.domain.Product;

public class OrderProductInMemoryRepository implements OrderPort {

    private Map<Long, Order> persistence = new HashMap<>();
    private Long sequence = 0L;


    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public void save(Order order) {
        order.assignId(++sequence);
        persistence.put(order.getId(), order);
    }
}
