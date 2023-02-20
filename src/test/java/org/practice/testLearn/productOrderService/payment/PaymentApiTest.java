package org.practice.testLearn.productOrderService.payment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.practice.testLearn.productOrderService.ApiTest;
import org.practice.testLearn.productOrderService.order.OrderSteps;
import org.practice.testLearn.productOrderService.product.ProductSteps;
import org.springframework.http.HttpStatus;

class PaymentApiTest extends ApiTest {

    @Test
    public void productOrderPaymentTest() throws Exception {
        ProductSteps.addProduct(ProductSteps.creatItemRequest());
        OrderSteps.orderProductCreationApi(OrderSteps.createOrderRequest());
        var request = PaymentSteps.createPayment();
        var response = PaymentSteps.getOrderPayment(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
