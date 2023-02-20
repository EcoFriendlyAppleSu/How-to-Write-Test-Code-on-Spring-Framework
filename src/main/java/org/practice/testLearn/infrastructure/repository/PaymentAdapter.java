package org.practice.testLearn.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.Payment;
import org.practice.testLearn.domain.PaymentGateway;
import org.practice.testLearn.domain.PaymentPort;
import org.practice.testLearn.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentAdapter implements PaymentPort {

    private final PaymentGateway gateway;
    private final PaymentInMemoryRepository repository;

    @Override
    public Order getOrder(Long orderId) {
        var product = Product.register("ItemName", 10000, DiscountPolicy.NONE);
        product.assignId(1L);
        return new Order(product, 2);
        /*return orderRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("입력한 주문이 존재하지 않습니다."));*/
    }

    @Override
    public void pay(int price, String cardNumber) {
        gateway.execute(price, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        repository.save(payment);
    }
}
