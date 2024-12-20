package com.egov.rabbitmqproducer.controller;

import com.egov.rabbitmqproducer.model.Order;
import com.egov.rabbitmqproducer.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final RabbitMQProducer producer;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        producer.sendOrder(order);
        return ResponseEntity.ok("Order sent to RabbitMQ successfully!");
    }
}
