package org.practice.testLearn.presentation;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.OrderService;
import org.practice.testLearn.application.result.CreateOrderResult;
import org.practice.testLearn.presentation.request.CreateOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderProductController {

    private final OrderService service;
    @PostMapping("/create")
    public ResponseEntity<CreateOrderResult> order(@RequestBody CreateOrderRequest request) {
        var order = service.createOrder(request);
        return ResponseEntity.ok(order);
    }
}
