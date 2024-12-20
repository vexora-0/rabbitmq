package com.egov.rabbitmqconsumer.service;

import com.egov.rabbitmqconsumer.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeOrder(Order order) {
        log.info("Received order: {}", order);
        processOrder(order);
    }

    private void processOrder(Order order) {
        // Simulate order processing
        try {
            Thread.sleep(1000); // Simulate some work being done
            log.info("Processing completed for order: {}", order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error processing order", e);
        }
    }
}