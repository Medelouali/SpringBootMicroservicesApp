package com.ensa.notifications;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "api/v1/notifications")
@AllArgsConstructor
public class NotificationsController {
    private final NotificationsService notificationsService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public NotificationRequestDto addNotification(@RequestBody() NotificationRequestDto notificationRequestDto){
        return notificationsService.addNotification(notificationRequestDto);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Notification> getNotifications(){
        return notificationsService.getNotifications();
    }
}
