package org.practice.testLearn.productOrderService.product;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.presentation.request.UpdateProductRequest;
import org.practice.testLearn.productOrderService.ApiTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class ProductApiTest extends ApiTest {

    @DisplayName("상품 등록 서비스 테스트")
    @Test
    public void addProductTest() throws Exception {
        var request = ProductSteps.creatItemRequest();
        var response = ProductSteps.addProduct(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @DisplayName("상품 조회 테스트")
    @Test
    public void productQueryTest() throws Exception {

        var product = ProductSteps.creatItemRequest();
        ProductSteps.addProduct(product);
        var productId = 1L;

        ExtractableResponse<Response> response = productSearchingRequest(productId);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("ItemName");
    }

    @DisplayName("상품 수정 테스트")
    @Test
    public void productUpdateTest() throws Exception {
        /*var product = ProductSteps.creatItemRequest();
        ProductSteps.addProduct(product);
        var productId = 1L;

        var response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(UpdateProductRequest.class)
            .when()
            .post("/products/update")
            .then()
            .log().all().extract();
*/
        /*
        * RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/products")
            .then()
            .log().all().extract();
        * */
    }

    private ExtractableResponse<Response> productSearchingRequest(long productId) {
        var response = RestAssured.given().log().all()
            .when()
            .get("/products/{productId}", productId)
            .then().log().all()
            .extract();
        return response;
    }
}
