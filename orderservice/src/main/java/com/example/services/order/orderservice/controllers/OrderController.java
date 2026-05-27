/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.order.orderservice.controllers;

import com.example.services.order.orderservice.entities.OrderEntity;
import com.example.services.order.orderservice.entities.UserEntity;
import com.example.services.order.orderservice.services.OrderService;
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
@RequestMapping("/orderController")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderEntity saveOrder(@RequestBody OrderEntity order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<OrderEntity> getOrderById() {
        return orderService.getAllOrder();
    }

    @GetMapping("/userId/{orderUserId}")
    public List<OrderEntity> getOrderByUserId(@PathVariable long orderUserId) {
        return orderService.getOrderByUserID(orderUserId);
    }

    @GetMapping("/orderID/{orderId}")
    public UserEntity getUserByOrderId(@PathVariable long orderId) {
        return orderService.getUserByOrderID(orderId);
    }

}
