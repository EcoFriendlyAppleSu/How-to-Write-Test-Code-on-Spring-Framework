package org.practice.testLearn.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.Payment;
import org.practice.testLearn.domain.PaymentPort;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentAdapter implements PaymentPort {

    private final PaymentJpaRepository paymentJpaRepository;
    private final OrderJpaRepository orderRepository;

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("입력한 주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(Payment payment) {

    }

    @Override
    public void save(Payment payment) {

    }
}
