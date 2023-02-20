package org.practice.testLearn.infrastructure.repository;

import org.practice.testLearn.domain.Payment;
import org.practice.testLearn.domain.PaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void execute(int price, String cardNumber) {
        System.out.println("결제 금액 = " + price + " 카드 번호 = " + cardNumber);
    }
}
