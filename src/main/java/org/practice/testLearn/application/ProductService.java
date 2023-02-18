package org.practice.testLearn.application;

import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.practice.testLearn.presentation.request.AddProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(AddProductRequest request) {
        Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
    }
}
