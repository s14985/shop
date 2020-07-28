package com.tin.shop.repository;

import com.tin.shop.model.Order;
import com.tin.shop.model.OrderProduct;
import com.tin.shop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
    Iterable<OrderProduct> findAllByPkProduct(Product product);
    Iterable<OrderProduct> findAllByPkOrder(Order order);
}
