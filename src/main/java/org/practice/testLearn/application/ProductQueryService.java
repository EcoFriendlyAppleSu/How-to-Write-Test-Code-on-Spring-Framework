package org.practice.testLearn.application;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.response.GetProductResponse;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductPort repository;

    public GetProductResponse getProduct(Long productId) {
        var product = repository.getProduct(productId);
        return new GetProductResponse(productId, product.getName(), product.getPrice(),
            product.getDiscountPolicy());
    }
}
