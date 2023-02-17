package org.practice.testLearn.productOrderService.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class ProductServiceTest {

    @DisplayName("상품 등록 서비스 테스트")
    @Test
    public void addItemTest() throws Exception {
        String name = "ItemName";
        int money = 10000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, money, discountPolicy);

    }

    private static class AddProductRequest {

        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
            Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
            this.name = name;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }
    }

    private enum DiscountPolicy {
        NONE

    }
}
