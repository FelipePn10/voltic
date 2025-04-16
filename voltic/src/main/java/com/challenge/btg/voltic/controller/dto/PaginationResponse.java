package com.challenge.btg.voltic.controller.dto;

public record PaginationResponse(Integer page,
                                 Integer pageSize,
                                 Long totalElements,
                                 Integer totalPages) {

    public static PaginationResponse fromOrderPage(Page<?> page) {
        return new PaginationResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
        )
    }
}
