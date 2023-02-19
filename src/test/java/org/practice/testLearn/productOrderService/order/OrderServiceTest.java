package org.practice.testLearn.productOrderService.order;

import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.OrderService;
import org.practice.testLearn.application.ProductService;
import org.practice.testLearn.productOrderService.product.ProductSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Test
    public void orderProductsTest() throws Exception {
        var addProductRequest = ProductSteps.creatItemRequest();
        productService.addProduct(addProductRequest);
        var request = OrderSteps.createOrderRequest();
        orderService.createOrder(request);
    }



}
