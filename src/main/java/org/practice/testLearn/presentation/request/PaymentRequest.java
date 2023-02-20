package org.practice.testLearn.presentation.request;

import org.practice.testLearn.application.command.PaymentCommand;
import org.springframework.util.Assert;

public record PaymentRequest(
    Long orderId,
    String cardNumber
) {

    public PaymentRequest {
        Assert.notNull(orderId, "상품 주문 번호는 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 16자리 숫자여야합니다.");
    }

    public PaymentCommand toCommand() {
        return new PaymentCommand(this.orderId, this.cardNumber);
    }
}
