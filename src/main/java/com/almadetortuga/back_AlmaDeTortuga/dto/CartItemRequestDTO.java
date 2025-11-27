package com.almadetortuga.back_AlmaDeTortuga.dto;

import java.math.BigDecimal;

public class CartItemRequestDTO {
    private Long productId;
    private Integer quantity;
    private String customDetailsJson;
    private BigDecimal finalUnitPrice;

    public CartItemRequestDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCustomDetailsJson() {
        return customDetailsJson;
    }

    public void setCustomDetailsJson(String customDetailsJson) {
        this.customDetailsJson = customDetailsJson;
    }

    public BigDecimal getFinalUnitPrice() {
        return finalUnitPrice;
    }

    public void setFinalUnitPrice(BigDecimal finalUnitPrice) {
        this.finalUnitPrice = finalUnitPrice;
    }
}
