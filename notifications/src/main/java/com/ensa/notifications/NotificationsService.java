package com.ensa.notifications;

import com.ensa.amqp.CustomMessage;
import com.ensa.amqp.RabbitMQConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
@Slf4j
public class NotificationsService {
    private final NotificationsRepository notificationsRepository;


    public NotificationRequestDto addNotification(NotificationRequestDto notificationRequestDto){
        Notification notification= Notification.builder().
                message(notificationRequestDto.getMessage()).
                clientId(notificationRequestDto.getClientId()).build();
        notificationsRepository.save(notification);
        log.info(notificationRequestDto.getMessage());

        return notificationRequestDto;
    }

    public List<Notification> getNotifications() {
        return this.notificationsRepository.findAll();
    }
}
