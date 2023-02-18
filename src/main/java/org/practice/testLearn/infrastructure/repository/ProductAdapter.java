package org.practice.testLearn.infrastructure.repository;

import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.practice.testLearn.infrastructure.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
