/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.notification.notificationService.services;

import com.example.notification.notificationService.entities.ReceiverNotificationMaster;
import com.example.notification.notificationService.repositories.ReceiverNotificationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ankit Vashistha
 */
@Service
public class ReceiverDetails {

    @Autowired
    private ReceiverNotificationRepository rnp;

    public String getReceiverEmailAddressFromSenderId(long receiverID) {
        System.out.println("inside:::::::getReceiverEmailAddressFromId:::::: " + receiverID);
        Optional<ReceiverNotificationMaster> rnm = rnp.findById(receiverID);
        String emailID = rnm.get().getR_emailAddress();
        return emailID;
    }
}
