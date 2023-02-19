package org.practice.testLearn.application;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.practice.testLearn.presentation.request.AddProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductPort productPort;

    @Transactional
    public void addProduct(AddProductRequest request) {
        Product product = Product.register(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
    }
}
