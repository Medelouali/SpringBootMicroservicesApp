package com.ensa.amqp;


import java.util.concurrent.CountDownLatch;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(CustomMessage message) {
        log.info("Received <" + message.getMessage() + ">");
        latch.countDown();
    }

}
