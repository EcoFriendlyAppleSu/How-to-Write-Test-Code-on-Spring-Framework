package org.practice.testLearn.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    public void getTotalPriceTest() throws Exception {
        var product = Product.register("itemName", 1000, DiscountPolicy.NONE);
        product.assignId(1L);
        var order = new Order(product, 2);
        var totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }
}
