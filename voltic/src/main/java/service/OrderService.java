package service;

import com.challenge.btg.voltic.controller.dto.OrderResponse;
import com.challenge.btg.voltic.dto.OrderCreatedDTO;
import com.challenge.btg.voltic.entity.OrderEntity;
import com.challenge.btg.voltic.entity.OrderItem;
import com.challenge.btg.voltic.repository.OrderRepository;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedDTO event) {

        var entity = new OrderEntity();
        entity.setOrderId(entity.getOrderId());
        entity.setCustomerId(entity.getCustomerId());

        getItems(event, entity);
        orderRepository.save(entity);

        entity.setTotalprice(getTotalPrice(event));
        orderRepository.save(entity);

    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        var orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(OrderResponse::fromOrderEntity);
    }

    private BigDecimal getTotalPrice(OrderCreatedDTO event) {
        return event.itens()
                .stream()
                .map(i -> i.price().multiply(BigDecimal.valueOf(i.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void getItems(OrderCreatedDTO event, OrderEntity entity) {
        entity.setItems(event.itens().stream()
                .map(i -> new OrderItem(i.product(), i.quantity(), i.price()))
                .toList());
    }
}
