/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.order.orderservice.services;

import com.example.services.order.orderservice.entities.OrderEntity;
import com.example.services.order.orderservice.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CCS
 */
@Service
public class OrderService {

    @Autowired
    private UserRepository UserRepository;

    public OrderEntity saveOrder(OrderEntity order) {
        return UserRepository.save(order);
    }

    public Optional<OrderEntity> getOrderById(long orderId) {
        return UserRepository.findById(orderId);
    }

    public List<OrderEntity> getAllOrder() {
        return UserRepository.findAll();
    }

    public List<OrderEntity> getOrderByUserID(long orderUserId) {
        return UserRepository.findByOrderUserId(orderUserId);
    }
}
