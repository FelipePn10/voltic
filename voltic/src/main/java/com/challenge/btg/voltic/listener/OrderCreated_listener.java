package com.challenge.btg.voltic.listener;

import com.challenge.btg.voltic.dto.OrderCreatedDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import service.OrderService;

import java.util.logging.Logger;

import static com.challenge.btg.voltic.config.RabbitMqConfig.ORDER_CREATER_QUEUE;


@Component
public class OrderCreated_listener {

    private final Logger logger = Logger.getLogger(OrderCreated_listener.class.getName());

    private final OrderService orderService;
    public OrderCreated_listener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATER_QUEUE)
        public void listen(Message<OrderCreatedDTO> message) {
            logger.info(String.format("Message consumed: %s", message));

            orderService.save(message.getPayload());
        }
}
