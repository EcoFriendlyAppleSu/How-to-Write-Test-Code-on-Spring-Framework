package org.practice.testLearn.application.result;

import org.practice.testLearn.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record GetProductResult(
    Long id,
    String name,
    int price,
    DiscountPolicy discountPolicy
) {

    public GetProductResult {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
