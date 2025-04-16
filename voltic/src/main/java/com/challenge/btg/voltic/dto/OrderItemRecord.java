package com.challenge.btg.voltic.dto;

import java.math.BigDecimal;

public record OrderItemRecord(
        String product,
        Integer quantity,
        BigDecimal price
) {
}
