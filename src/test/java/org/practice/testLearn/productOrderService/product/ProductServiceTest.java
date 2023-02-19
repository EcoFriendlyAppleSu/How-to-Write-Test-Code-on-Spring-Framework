package org.practice.testLearn.productOrderService.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.ProductQueryService;
import org.practice.testLearn.application.result.GetProductResult;
import org.practice.testLearn.presentation.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest{

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
        var request = ProductSteps.creatItemRequest();
        controller.addProductController(request);
        Long productId = 1L;

        // 상품을 조회
        GetProductResult response = service.getProduct(productId);

        // 상품의 응답을 검증
        assertThat(response).isNotNull();
    }
}
