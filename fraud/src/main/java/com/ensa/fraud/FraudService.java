package com.ensa.fraud;

import ch.qos.logback.core.net.server.Client;
import com.ensa.amqp.CustomMessage;
import com.ensa.amqp.MessagingConfig;
import com.ensa.amqp.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class FraudService {
    private final FraudRepository fraudRepository;
    private final NotificationsFeignInterface notificationsFeignInterface;
    private final AmqpTemplate template;

    public boolean isFraud(String customerId) {
        return false;
    }

    public FlagFraudResponse flagClient(String customerId){
        Fraud fraud=Fraud.builder()
                .isFraudulent(false).id(customerId)
                .build();
        this.fraudRepository.saveAndFlush(fraud);
        try{
            notificationsFeignInterface.addNotification(
                    new NotificationRequestDto(customerId, "Client is not flagged")
            );
            CustomMessage message=new CustomMessage();
            message.setMessage(customerId+" was not flagged as fraud");
            message.setMessageDate(new Date());
            message.setMessageId(UUID.randomUUID().toString());

            template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
            log.info("Message was sent");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new FlagFraudResponse(customerId);
    }

    public List<String> getFlagged(){
        return this.fraudRepository.findAll().stream().filter(Fraud::isFraudulent)
                .toList()
                .stream().map(Fraud::getId).collect(Collectors.toList());
    }

    public List<String> getUnflagged(){
        return this.fraudRepository.findAll().stream().filter(fraud -> !fraud.isFraudulent())
                .toList()
                .stream().map(Fraud::getId).collect(Collectors.toList());
    }
}
