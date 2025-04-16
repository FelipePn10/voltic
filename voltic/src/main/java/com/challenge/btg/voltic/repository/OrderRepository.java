package com.challenge.btg.voltic.repository;

import com.challenge.btg.voltic.controller.dto.OrderResponse;
import com.challenge.btg.voltic.entity.OrderEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
