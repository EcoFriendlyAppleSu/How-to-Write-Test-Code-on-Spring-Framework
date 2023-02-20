package org.practice.testLearn.productOrderService.payment;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.PaymentService;
import org.practice.testLearn.domain.PaymentGateway;
import org.practice.testLearn.domain.PaymentPort;
import org.practice.testLearn.infrastructure.repository.ConsolePaymentGateway;
import org.practice.testLearn.infrastructure.repository.PaymentAdapter;
import org.practice.testLearn.infrastructure.repository.PaymentInMemoryRepository;
import org.practice.testLearn.presentation.request.PaymentRequest;

public class PaymentServiceTest {

    private PaymentPort paymentPort;
    private PaymentService service;
    private PaymentGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = new ConsolePaymentGateway();
        paymentPort = new PaymentAdapter(gateway, new PaymentInMemoryRepository());
        service = new PaymentService(paymentPort);
    }

    @DisplayName("상품 주문")
    @Test
    public void productPaymentServiceTest() throws Exception {
        PaymentRequest request = PaymentSteps.createPayment();
        service.payment(request.toCommand());
    }



}
