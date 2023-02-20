package org.practice.testLearn.domain;

public interface PaymentPort {

    Order getOrder(Long orderId);

    void pay(int price, String cardNumber);

    void save(Payment payment);
}
