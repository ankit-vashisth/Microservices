/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.notification.notificationService.controllers;

import com.example.notification.notificationService.services.SenderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ankit Vashistha
 */
@RestController
@RequestMapping("/sendNotification")
public class SendNotificationController {

    @Autowired
    private SenderDetails senderDetails;

    @GetMapping("/{senderEmailIDNo}")
    public String notificationSendBySenderID(@PathVariable long senderEmailIDNo, @RequestParam String body) {
        String returnMessage = "";
        returnMessage = senderDetails.sendNotificationBySenderID(senderEmailIDNo, body);
        return returnMessage;
    }
}
