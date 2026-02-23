package com.example.kafka.service;

import com.example.kafka.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private static final String TOPIC = "order-topic";

    public void sendOrder(Order order) {
        kafkaTemplate.send(TOPIC, order);
    }
}