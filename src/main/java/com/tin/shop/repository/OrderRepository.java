package com.tin.shop.repository;

import com.tin.shop.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Iterable<Order> findAllByUser(Long id);
}
