package org.practice.testLearn.productOrderService.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

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
        final AddProductRequest request = new AddProductRequest(name, money, discountPolicy);
        return request;
    }

}
