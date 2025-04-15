package com.challenge.btg.voltic.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String ORDER_CREATER_QUEUE = "btg-pactual-order-created";
}
