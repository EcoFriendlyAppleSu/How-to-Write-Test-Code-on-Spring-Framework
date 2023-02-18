package org.practice.testLearn.infrastructure.repository;

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
}
