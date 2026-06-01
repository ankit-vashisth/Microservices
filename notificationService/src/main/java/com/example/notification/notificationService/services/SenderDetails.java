/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.notification.notificationService.services;

import com.example.notification.notificationService.entities.ReceiverNotificationMaster;
import com.example.notification.notificationService.entities.SenderNotificationMaster;
import com.example.notification.notificationService.repositories.ReceiverNotificationRepository;
import com.example.notification.notificationService.repositories.SenderNotificationRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ankit Vashistha
 */
@Service
public class SenderDetails {

    @Autowired
    private SenderNotificationRepository SenderNotificationRepository;
    @Autowired
    private ReceiverDetails ReceiverDetails;

    public String sendNotificationBySenderID(long senderId, String mailbody) {
        Optional<SenderNotificationMaster> snm = SenderNotificationRepository.findById(senderId);
        String messageff = "";
        if (snm != null && !snm.isEmpty()) {
            messageff = mailConfigurationAndSendNotification(snm, mailbody);
        }
        return messageff;
    }

    public String mailConfigurationAndSendNotification(Optional<SenderNotificationMaster> snm, String mailbody) {
        System.out.println("inside::::::::: mailConfigurationAndSendNotification::::::::::: ");
        String messageFF = "";

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(snm.get().getS_hostName());
        mailSender.setPort(snm.get().getS_portNo());
        mailSender.setUsername(snm.get().getS_emailAddress());
        mailSender.setPassword(snm.get().getS_emailPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(snm.get().getS_emailAddress());
            String[] str = snm.get().getS_receiverEmailID().split(",");
            String subject = "Alert Notification.";
            List<String> receiverEmailID = getReceiverEmailID(str);
            for (String toEmail : receiverEmailID) {
                System.out.println("send to::::::: " + toEmail);
                helper.setTo(toEmail);
                helper.setSubject(subject);
                helper.setText(mailbody, true);
                System.out.println("going to send email ::::::::::::::::Vashistha:::::::::::");
                mailSender.send(message);
            }
            messageFF = "Notification send successfully.";
        } catch (MessagingException e) {
            messageFF = "Something went wrong to send mail.";
            throw new RuntimeException("Failed to send email", e);
        }
        return messageFF;
    }

    public List<String> getReceiverEmailID(String[] str) {
        List<String> receiverEmailAddresses = new ArrayList<>();
        for (String emailIDNo : str) {
            receiverEmailAddresses.add(ReceiverDetails.getReceiverEmailAddressFromSenderId(Long.parseLong(emailIDNo)));
        }
        System.out.println("receiver email address:::::::::: " + receiverEmailAddresses);
        return receiverEmailAddresses;
    }

}
