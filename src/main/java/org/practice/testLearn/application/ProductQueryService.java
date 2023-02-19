package org.practice.testLearn.application;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.result.GetProductResult;
import org.practice.testLearn.domain.ProductPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductPort repository;

    public GetProductResult getProduct(Long productId) {
        var product = repository.getProduct(productId);
        return new GetProductResult(productId, product.getName(), product.getPrice(),
            product.getDiscountPolicy());
    }
}
