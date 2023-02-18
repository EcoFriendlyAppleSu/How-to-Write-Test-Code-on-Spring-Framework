package org.practice.testLearn.productOrderService;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

/*
* Random port generate
* */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Autowired
    private DatabaseCleanUp databaseCleanUp;


    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        // port를 찾을 수 없을 때 port를 등록해주고 Table, Entity를 세팅해줍니다.
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
            databaseCleanUp.afterPropertiesSet();
        }
        // BeforeEach마다 DB를 Clear해줍니다.
        databaseCleanUp.execute();

    }
}
