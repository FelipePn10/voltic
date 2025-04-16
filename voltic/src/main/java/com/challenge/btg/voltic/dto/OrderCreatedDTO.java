package com.challenge.btg.voltic.dto;

import java.util.List;

public record OrderCreatedDTO(
        Long codeOrder,
        Long codeClient,
        List<OrderItemRecord> itens
) {
}
