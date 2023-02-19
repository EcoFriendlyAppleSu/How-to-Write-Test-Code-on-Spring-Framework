package org.practice.testLearn.domain;

public interface OrderPort {

    Product getProductById(Long productId);

    void save(Order order);
}
