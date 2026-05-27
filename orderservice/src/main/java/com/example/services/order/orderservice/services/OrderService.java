/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.order.orderservice.services;

import com.example.services.order.orderservice.entities.OrderEntity;
import com.example.services.order.orderservice.entities.UserEntity;
import com.example.services.order.orderservice.repositories.UserRepository;
import jakarta.ws.rs.HttpMethod;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author CCS
 */
@Service
public class OrderService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderEntity saveOrder(OrderEntity order) {
        return UserRepository.save(order);
    }

    public Optional<OrderEntity> getOrderById(long orderId) {
        Optional<OrderEntity> order = UserRepository.findById(orderId);
        return order;
    }

    public List<OrderEntity> getAllOrder() {
        return UserRepository.findAll();
    }

    public List<OrderEntity> getOrderByUserID(long orderUserId) {
        return UserRepository.findByOrderUserId(orderUserId);
    }

    public UserEntity getUserByOrderID(long orderId) {
        Optional<OrderEntity> order = UserRepository.findById(orderId);
        if (order.isPresent()) {
            long userIdFromOrder = order.get().getOrderUserId();
            ResponseEntity<UserEntity> response = restTemplate.exchange(
                    "http://USER-SERVICE/userController/" + userIdFromOrder,
                    org.springframework.http.HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<UserEntity>() {
            }
            );
            return response.getBody();
        }
        return null;
    }
}
