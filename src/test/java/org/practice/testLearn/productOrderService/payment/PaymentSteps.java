package org.practice.testLearn.productOrderService.payment;

import org.practice.testLearn.presentation.request.PaymentRequest;

public class PaymentSteps {

    public static PaymentRequest createPayment() {
        var orderId = 1L;
        var cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }

}
