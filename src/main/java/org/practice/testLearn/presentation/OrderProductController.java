package org.practice.testLearn.presentation;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.OrderService;
import org.practice.testLearn.presentation.request.CreateOrderRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderProductController {

    private final OrderService service;
    @GetMapping
    public void order(@RequestBody CreateOrderRequest request) {
        service.createOrder(request.toCommand());
    }
}
