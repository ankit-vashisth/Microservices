/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services.order.orderservice.repositories;

import com.example.services.order.orderservice.entities.OrderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CCS
 */
@Repository
public interface UserRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByOrderUserId(long orderUserId);
}
