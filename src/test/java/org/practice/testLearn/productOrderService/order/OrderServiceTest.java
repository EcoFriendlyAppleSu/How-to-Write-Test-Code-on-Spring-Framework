package org.practice.testLearn.productOrderService.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.practice.testLearn.application.OrderService;
import org.practice.testLearn.domain.DiscountPolicy;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.OrderPort;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.infrastructure.repository.OrderAdapter;
import org.practice.testLearn.infrastructure.repository.OrderJpaRepository;
import org.practice.testLearn.infrastructure.repository.OrderProductInMemoryRepository;
import org.practice.testLearn.infrastructure.repository.ProductJpaRepository;
import org.practice.testLearn.presentation.request.CreateOrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderProductInMemoryRepository repository;
    private OrderPort orderPort;

    @BeforeEach
    void setUp() {
        repository = new OrderProductInMemoryRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(Long productId) {
                return Product.register("상품명", 10000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                repository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    public void orderProductsTest() throws Exception {
        var productId = 1L;
        var quantity = 2;
        var request = new CreateOrderRequest(productId, quantity);

        orderService.createOrder(request.toCommand());
    }

}
