package org.practice.testLearn.productOrderService.product;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.presentation.request.AddProductRequest;
import org.practice.testLearn.productOrderService.ApiTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class ProductApiTest extends ProductSteps {

    @DisplayName("상품 등록 서비스 테스트")
    @Test
    public void addItemTest() throws Exception {
        var request = creatItemRequest();
        var response = itemRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
