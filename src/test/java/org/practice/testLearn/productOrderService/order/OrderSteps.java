package org.practice.testLearn.productOrderService.order;

import org.practice.testLearn.presentation.request.CreateOrderRequest;

public class OrderSteps {

    public static CreateOrderRequest createOrderRequest() {
        var productId = 1L;
        var quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}
