package org.practice.testLearn.productOrderService.payment;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.practice.testLearn.presentation.request.PaymentRequest;
import org.springframework.http.MediaType;

public class PaymentSteps {

    public static PaymentRequest createPayment() {
        var orderId = 1L;
        var cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }

    public static ExtractableResponse<Response> getOrderPayment(PaymentRequest request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/payments")
            .then().log().all()
            .extract();
    }
}
