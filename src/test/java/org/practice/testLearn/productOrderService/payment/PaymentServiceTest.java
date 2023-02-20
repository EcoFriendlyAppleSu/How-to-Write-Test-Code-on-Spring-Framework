package org.practice.testLearn.productOrderService.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.OrderService;
import org.practice.testLearn.application.PaymentService;
import org.practice.testLearn.application.ProductService;
import org.practice.testLearn.presentation.request.PaymentRequest;
import org.practice.testLearn.productOrderService.order.OrderSteps;
import org.practice.testLearn.productOrderService.product.ProductSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTest {


    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;


    @DisplayName("상품 주문")
    @Test
    public void productPaymentServiceTest() throws Exception {
        productService.addProduct(ProductSteps.creatItemRequest());
        orderService.createOrder(OrderSteps.createOrderRequest());
        PaymentRequest request = PaymentSteps.createPayment();
        paymentService.payment(request.toCommand());
    }


}
