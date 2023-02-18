package org.practice.testLearn.productOrderService.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.ProductService;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.presentation.request.AddProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @DisplayName("상품 등록 서비스 테스트")
    @Test
    public void addItemTest() throws Exception {
        final AddProductRequest request = creatItemRequest();

        productService.addProduct(request);
    }

    private AddProductRequest creatItemRequest() {
        String name = "ItemName";
        int money = 10000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, money, discountPolicy);
    }

}
