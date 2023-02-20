package org.practice.testLearn.domain;

public interface PaymentPort {

    Order getOrder(Long orderId);

    void pay(Payment payment);

    void save(Payment payment);
}
