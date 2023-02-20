package org.practice.testLearn.presentation;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.PaymentService;
import org.practice.testLearn.presentation.request.PaymentRequest;
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
    public void payment(@RequestBody PaymentRequest request) {
        service.payment(request.toCommand());
    }
}
