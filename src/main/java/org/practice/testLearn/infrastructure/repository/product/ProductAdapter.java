package org.practice.testLearn.infrastructure.repository.product;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

    private final ProductJpaRepository repository;

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {
        return repository.findById(productId).orElseThrow(() -> new IllegalArgumentException());
    }

}
