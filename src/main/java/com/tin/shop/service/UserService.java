package com.tin.shop.service;

import com.tin.shop.model.Order;
import com.tin.shop.model.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
public interface UserService {

    @NotNull Iterable<User> getAllUsers();

    User getUserById(@Min(value = 1L, message = "Invalid user ID.") long id);

    User save(User user);

    User getCurrentUser();

    User getUserByOrder(Order order);
}
