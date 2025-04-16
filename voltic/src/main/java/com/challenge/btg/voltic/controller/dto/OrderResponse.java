package com.challenge.btg.voltic.controller.dto;

import com.challenge.btg.voltic.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

    public static OrderResponse fromOrderEntity(OrderEntity orderEntity) {
        return new OrderResponse(orderEntity.getOrderId(), orderEntity.getCustomerId(), orderEntity.getTotalprice());
}
