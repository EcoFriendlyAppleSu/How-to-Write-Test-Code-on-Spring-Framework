package org.practice.testLearn.productOrderService.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.ProductQueryService;
import org.practice.testLearn.application.response.GetProductResponse;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.domain.ProductPort;
import org.practice.testLearn.presentation.ProductController;
import org.practice.testLearn.presentation.request.AddProductRequest;
import org.practice.testLearn.productOrderService.ApiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductController controller;

    @Autowired
    private ProductQueryService service;

    /*
     * 검증에 필요한 부분을 작성하고 진행합니다.
     * */
    @Test
    public void productFindBySomethingTest() throws Exception {
        // 상품 등록
        var request = creatItemRequest();
        controller.addProductController(request);
        Long productId = 1L;

        // 상품을 조회
        GetProductResponse response = service.getProduct(productId);

        // 상품의 응답을 검증
        assertThat(response).isNotNull();
    }

    private AddProductRequest creatItemRequest() {
        String name = "ItemName";
        int money = 10000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, money, discountPolicy);
    }

}
