package org.practice.testLearn.infrastructure.repository.order;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.domain.Order;
import org.practice.testLearn.domain.OrderPort;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.infrastructure.repository.product.ProductJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final OrderJpaRepository orderRepository;
    private final ProductJpaRepository productRepository;

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
