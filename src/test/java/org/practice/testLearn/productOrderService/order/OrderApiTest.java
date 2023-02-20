package org.practice.testLearn.productOrderService.order;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.presentation.request.CreateOrderRequest;
import org.practice.testLearn.productOrderService.ApiTest;
import org.practice.testLearn.productOrderService.product.ProductSteps;
import org.springframework.http.MediaType;

public class OrderApiTest extends ApiTest {

    @DisplayName("주문 등록 테스트")
    @Test
    public void orderProductCreationApiTest() throws Exception {
        // 상품 등록 request
        ProductSteps.addProduct(ProductSteps.creatItemRequest());
        var request = OrderSteps.createOrderRequest();

        // 상품 주문
        var response = OrderSteps.orderProductCreationApi(request);

        // 주문 상품 검증
        assertThat(response.jsonPath().getString("name")).isEqualTo("ItemName");
    }



}
