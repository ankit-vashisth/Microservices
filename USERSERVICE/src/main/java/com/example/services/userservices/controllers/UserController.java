/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.userservices.controllers;

import com.example.services.userservices.entities.OrderEntity;
import com.example.services.userservices.entities.UserEntity;
import com.example.services.userservices.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CCS
 */
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping("/saveUser")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return UserService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable long id) {
        return UserService.getUserById(id);
    }

    @GetMapping
    public List<UserEntity> geAllUser() {
        System.out.println("getAllUser::::::::::::::::::::::::");
        return UserService.getAllUserList();
    }

    @GetMapping("/orderDetails/{userId}")
    public List<OrderEntity> getALLOrderByUserId(@PathVariable long userId) {
        return UserService.getAllOrderByUserId(userId);
    }

    @GetMapping("/orderOnly/{orderId}")
    public OrderEntity getOrderOnly(@PathVariable long orderId) {
        return UserService.getOrderById(orderId);
    }

    @PostMapping("/createOrder")
    public OrderEntity saveOrder(@RequestBody OrderEntity order) {
        System.out.println("Saving the order:::::::::");
        return UserService.saveOrder(order);
    }
}
