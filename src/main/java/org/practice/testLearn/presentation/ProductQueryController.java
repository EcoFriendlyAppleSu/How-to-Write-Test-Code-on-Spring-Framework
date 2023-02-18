package org.practice.testLearn.presentation;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.ProductQueryService;
import org.practice.testLearn.application.response.GetProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService service;

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProductById(@PathVariable Long productId) {
        var product = service.getProduct(productId);
        return ResponseEntity.ok(product);
    }

}
