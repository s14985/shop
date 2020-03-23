package com.tin.shop.controller;

import com.tin.shop.model.User;
import com.tin.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public @NotNull Iterable<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public @NotNull User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/current")
    public @NotNull User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PutMapping("/current")
    public User updateCurrentUser(@RequestBody User user){
        return userService.save(user);
    }
}
