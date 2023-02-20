package org.practice.testLearn.productOrderService.payment;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.PaymentService;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.Payment;
import org.practice.testLearn.domain.PaymentGateway;
import org.practice.testLearn.domain.PaymentPort;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.infrastructure.repository.ConsolePaymentGateway;
import org.practice.testLearn.infrastructure.repository.PaymentJpaRepository;
import org.practice.testLearn.presentation.request.PaymentRequest;

public class PaymentServiceTest {

    private PaymentPort paymentPort;
    private PaymentService service;

    @BeforeEach
    void setUp() {
        paymentPort = new PaymentTestAdapter(new ConsolePaymentGateway(), new PaymentRepository());
        service = new PaymentService(paymentPort);
    }

    @DisplayName("상품 주문")
    @Test
    public void productPaymentServiceTest() throws Exception {
        PaymentRequest request = PaymentSteps.createPayment();
        service.payment(request.toCommand());
    }

    private class PaymentTestAdapter implements PaymentPort {

        private final PaymentGateway gateway;
        private final PaymentRepository repository;

        public PaymentTestAdapter(PaymentGateway gateway, PaymentRepository repository) {
            this.gateway = gateway;
            this.repository = repository;
        }

        @Override
        public Order getOrder(Long orderId) {
            var product = Product.register("ItemName", 10000, DiscountPolicy.NONE);
            product.assignId(1L);
            return new Order(product, 2);
        }

        @Override
        public void pay(Payment payment) {
            gateway.execute(payment);
        }

        @Override
        public void save(Payment payment) {

        }
    }

    private class PaymentRepository {

        private Map<Long, Payment> persistence = new HashMap<>();
        private Long sequence = 0L;

        public void save(Payment payment) {
            payment.assignId(++sequence);
            persistence.put(payment.getId(), payment);
        }
    }



}
