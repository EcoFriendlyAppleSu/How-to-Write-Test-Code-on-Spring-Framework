package org.practice.testLearn.application.result;

import org.practice.testLearn.domain.DiscountPolicy;

public record UpdateProductResult(
    Long id,
    String name,
    int price,
    DiscountPolicy discountPolicy
) {


}
