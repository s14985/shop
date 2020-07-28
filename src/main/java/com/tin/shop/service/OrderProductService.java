package com.tin.shop.service;

import com.tin.shop.model.Order;
import com.tin.shop.model.OrderProduct;
import com.tin.shop.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
    Iterable<OrderProduct> getAllByProduct(Product product);
    Iterable<OrderProduct> getAllByOrder(Order order);
}
