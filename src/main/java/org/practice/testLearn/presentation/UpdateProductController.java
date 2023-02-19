package org.practice.testLearn.presentation;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.ProductUpdateService;
import org.practice.testLearn.application.result.UpdateProductResult;
import org.practice.testLearn.presentation.request.UpdateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class UpdateProductController {

    private final ProductUpdateService service;

    @PostMapping("/update/{productId}")
    public ResponseEntity<UpdateProductResult> update(@RequestBody UpdateProductRequest request, @PathVariable Long productId) {
        var updatedProduct = service.update(request.toCommand(), productId);
        return ResponseEntity.ok(updatedProduct);
    }
}
