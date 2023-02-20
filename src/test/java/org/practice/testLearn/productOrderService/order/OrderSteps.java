package org.practice.testLearn.productOrderService.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.practice.testLearn.presentation.request.CreateOrderRequest;
import org.springframework.http.MediaType;

public class OrderSteps {

    public static CreateOrderRequest createOrderRequest() {
        var productId = 1L;
        var quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

    public static ExtractableResponse<Response> orderProductCreationApi(CreateOrderRequest request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/orders")
            .then()
            .log().all()
            .extract();
    }
}
