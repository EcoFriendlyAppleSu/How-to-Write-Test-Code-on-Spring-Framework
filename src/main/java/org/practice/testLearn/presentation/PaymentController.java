package org.practice.testLearn.presentation;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.PaymentService;
import org.practice.testLearn.presentation.request.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public ResponseEntity<Void> payment(@RequestBody PaymentRequest request) {
        service.payment(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
