package com.example.demo.Queue;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;


@Configuration
public class AMQPconfiguration {

    @Bean
    public TopicExchange roundTopicExchange(
            @Value("${amqp.exchange.name}") final String exchangeName
    ){
        return ExchangeBuilder
                .topicExchange(exchangeName)
                .durable(true)
                .build();
    }

    @Bean
    public Binding GenerateWorkoutBinding(
            final Queue workoutGenQueue,
            final TopicExchange TopicExchange
    ){
        return BindingBuilder
                .bind(workoutGenQueue)
                .to(TopicExchange)
                .with("round.won");
    }

}
