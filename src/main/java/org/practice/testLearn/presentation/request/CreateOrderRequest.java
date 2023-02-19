package org.practice.testLearn.presentation.request;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.practice.testLearn.application.command.OrderProductCommand;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public record CreateOrderRequest(
    Long productId,
    int quantity
) {

    public CreateOrderRequest {
        Assert.notNull(productId, "상품 ID는 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }

    public OrderProductCommand toCommand() {
        return new OrderProductCommand(productId, quantity);
    }
}
