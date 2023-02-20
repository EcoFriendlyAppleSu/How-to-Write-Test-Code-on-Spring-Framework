package org.practice.testLearn.infrastructure.repository;

import org.practice.testLearn.domain.Payment;
import org.practice.testLearn.domain.PaymentGateway;

public class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void execute(Payment payment) {
        System.out.println("결제 완료");
    }
}
