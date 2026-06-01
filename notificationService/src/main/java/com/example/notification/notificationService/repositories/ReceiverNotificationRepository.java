/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.notification.notificationService.repositories;

import com.example.notification.notificationService.entities.ReceiverNotificationMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ankit Vashistha
 */
@Repository
public interface ReceiverNotificationRepository extends JpaRepository<ReceiverNotificationMaster, Long> {

}
