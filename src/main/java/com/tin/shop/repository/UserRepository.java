package com.tin.shop.repository;

import com.tin.shop.model.Order;
import com.tin.shop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByOrders(Order order);
}
