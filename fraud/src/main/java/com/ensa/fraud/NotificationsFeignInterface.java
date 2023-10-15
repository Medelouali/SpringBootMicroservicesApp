package com.ensa.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("NOTIFICATIONS")
public interface NotificationsFeignInterface {
    @RequestMapping(path = "api/v1/notifications", method = RequestMethod.POST)
    public NotificationRequestDto addNotification(@RequestBody() NotificationRequestDto notificationRequestDto);
}
