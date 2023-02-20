package org.practice.testLearn.productOrderService.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.ProductQueryService;
import org.practice.testLearn.application.ProductService;
import org.practice.testLearn.application.ProductUpdateService;
import org.practice.testLearn.application.result.GetProductResult;
import org.practice.testLearn.application.result.UpdateProductResult;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest{

    @Autowired
    private ProductService service;

    @Autowired
    private ProductQueryService queryService;

    @Autowired
    private ProductPort port;

    @Autowired
    private ProductUpdateService updateService;

    /*
     * 검증에 필요한 부분을 작성하고 진행합니다.
     * */
    @Test
    public void productFindBySomethingTest() throws Exception {
        // 상품 등록
        var request = ProductSteps.creatItemRequest();
        service.addProduct(request);
        Long productId = 1L;

        // 상품을 조회
        GetProductResult response = queryService.getProduct(productId);

        // 상품의 응답을 검증
        assertThat(response).isNotNull();
    }

    @Test
    public void productUpdateTest() throws Exception {
        // save
        service.addProduct(ProductSteps.creatItemRequest());
        var productId = 1L;
        var request = ProductSteps.updateProductRequest();

        var updateProductResult = updateService.update(request.toCommand(), productId);
        assertThat(updateProductResult.name()).isEqualTo("updateItem");
    }

    @Test
    public void noneDiscountProduct() throws Exception {
        var product = Product.register("itemName", 10000, DiscountPolicy.NONE);
        int discountPrice = product.getDiscountPrice();
        Assertions.assertThat(discountPrice).isEqualTo(10000);
    }

    @Test
    public void fixDiscountProduct() throws Exception {
        var product = Product.register("itemName", 10000, DiscountPolicy.FIX_1000_AMOUNT);
        int discountPrice = product.getDiscountPrice();
        Assertions.assertThat(discountPrice).isEqualTo(9000);
    }
}
