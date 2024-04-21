package com.geovannycode.notifications.events;

import com.geovannycode.notifications.domain.models.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventHandler {
    private static final Logger log = LoggerFactory.getLogger(OrderEventHandler.class);

    @RabbitListener(queues = "${notification.new-orders-queue}")
    public void handle(OrderCreatedEvent event) {
        System.out.println("Event received: " + event);
    }
}
