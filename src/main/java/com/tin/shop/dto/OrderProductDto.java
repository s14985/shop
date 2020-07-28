package com.tin.shop.dto;

import com.tin.shop.model.Product;
import com.tin.shop.model.User;
import lombok.Data;

@Data
public class OrderProductDto {
    private Product product;
    private Integer quantity;
}
