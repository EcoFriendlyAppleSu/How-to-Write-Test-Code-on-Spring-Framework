package org.practice.testLearn.application.result;

import org.springframework.util.Assert;

public record CreateOrderResult(
    String name,
    int price,
    int quantity
) {

    public CreateOrderResult {
        Assert.notNull(name, "상품 이름은 필수입니다.");
        Assert.isTrue(price >0, "상품 가격은 0 이상입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }
}
