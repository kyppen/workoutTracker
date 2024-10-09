package com.example.demo.Queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send")
    public String sendMessage() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "routingKey", "Hello from RabbitMQ!");
        return "Message sent!";
    }
}