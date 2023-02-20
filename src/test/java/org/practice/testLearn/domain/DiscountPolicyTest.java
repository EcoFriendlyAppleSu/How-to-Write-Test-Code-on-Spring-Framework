package org.practice.testLearn.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    public void discountPolicyNonePriceTest() throws Exception {
        int price = 10000;
        int discountPrice = DiscountPolicy.NONE.applyDiscount(price);
        assertThat(discountPrice).isEqualTo(price);
    }

    @Test
    public void discountPolicyFix1000AmountTest() throws Exception {
        int price = 10000;
        int expectDiscountPrice = 9000;
        int discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountPrice).isEqualTo(expectDiscountPrice);
    }

}
