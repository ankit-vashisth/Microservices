/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.userservices.services;

import com.example.services.userservices.entities.OrderEntity;
import com.example.services.userservices.entities.UserEntity;
import com.example.services.userservices.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author CCS
 */
@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity user) {
        UserEntity createdUser = UserRepository.save(user);
        return createdUser;
    }

    public List<UserEntity> getAllUserList() {
        List<UserEntity> allUser = UserRepository.findAll();
        try {
            if (!allUser.isEmpty()) {
                System.out.println("inside::::::::2222 " + allUser.size());
                for (int i = 0; i < allUser.size(); i++) {
                    List<OrderEntity> OrderEntity = getAllOrderByUserId(allUser.get(i).getUserId());
                    allUser.get(i).setOrderEntity(OrderEntity);
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println("Order Service is not working:::");
            return allUser;
        }
        return allUser;
    }

    public Optional<UserEntity> getUserById(long userId) {
        Optional<UserEntity> User = UserRepository.findById(userId);
        try {
            if (User.isPresent()) {
                List<OrderEntity> OrderEntity = getAllOrderByUserId(User.get().getUserId());
                if (!OrderEntity.isEmpty()) {
                    User.get().setOrderEntity(OrderEntity);
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println("Order Service is not working:::");
            return User;
        }
        return User;
    }

    public List<OrderEntity> getAllOrderByUserId(long userId) {
        System.out.println("calling API second:::::::::::::");
        ResponseEntity<List<OrderEntity>> response
                = restTemplate.exchange(
                        "http://ORDER-SERVICE/orderController/userId/" + userId,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<OrderEntity>>() {
                }
                );
        return response.getBody();
    }

    public OrderEntity getOrderById(long orderId) {
        System.out.println("inside:::::::getOrderById");
        OrderEntity orderByID = restTemplate.getForObject("http://ORDER-SERVICE/orderController/" + orderId, OrderEntity.class);
        return orderByID;
    }

    public OrderEntity saveOrder(OrderEntity order) {
        System.out.println("inside::::::: saving order from userService");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OrderEntity> requestEntity
                = new HttpEntity<>(order, headers);

        ResponseEntity<OrderEntity> response
                = restTemplate.exchange(
                        "http://ORDER-SERVICE/orderController",
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<OrderEntity>() {
                }
                );

        return response.getBody();
    }

}
