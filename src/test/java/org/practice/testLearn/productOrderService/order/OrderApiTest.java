package org.practice.testLearn.productOrderService.order;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        var response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/orders/create")
            .then()
            .log().all()
            .extract();

        // 주문 상품 검증
        assertThat(response.jsonPath().getString("name")).isEqualTo("ItemName");
    }

}
