package com.example.Validator.Validating;


import com.example.Validator.jsonUtils.JsonUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {


    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ValidatorService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(WorkoutPlan workoutPlan) {
        //rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try(Connection connection = connectionFactory.newConnection()){
            Channel channel = connection.createChannel();
            channel.queueDeclare("GeneratorQueue", true, false,false, null);
            String message = JsonUtil.serialize(workoutPlan);
            channel.basicPublish("", "GeneratorQueue", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("Message sent: " + message);
    }
    public void sendMessage2(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        System.out.println("Message sent: " + message);
    }
}
