package com.example.kafka.controller;

import com.example.kafka.model.Order;
import com.example.kafka.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer producer;

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        producer.sendOrder(order);
        System.out.println(" order id : " + order.getOrderId());
        return "Order sent to payment service";
    }
}