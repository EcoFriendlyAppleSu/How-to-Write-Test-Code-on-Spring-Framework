package org.practice.testLearn.application;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.command.PaymentCommand;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.Payment;
import org.practice.testLearn.domain.PaymentPort;
import org.practice.testLearn.presentation.request.PaymentRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentPort paymentPort;

    @Transactional
    public void payment(PaymentCommand command) {
        var order = paymentPort.getOrder(command.orderId());
        var payment = new Payment(order, command.cardNumber());
        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);
    }

}
