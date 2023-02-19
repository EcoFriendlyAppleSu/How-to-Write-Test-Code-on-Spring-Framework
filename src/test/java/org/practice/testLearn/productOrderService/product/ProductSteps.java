package org.practice.testLearn.productOrderService.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.presentation.request.AddProductRequest;
import org.springframework.http.MediaType;

public class ProductSteps {

    // 상품 등록, json type으로 등록되는 부분입니다.
    public static ExtractableResponse<Response> addProduct(
        AddProductRequest request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/products")
            .then()
            .log().all().extract();
    }

    // 상품 등록 요청 생성
    public static AddProductRequest creatItemRequest() {
        String name = "ItemName";
        int money = 10000;
        DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, money, discountPolicy);
    }
}
