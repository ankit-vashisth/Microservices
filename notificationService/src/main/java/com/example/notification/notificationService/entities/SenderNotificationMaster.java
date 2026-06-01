package com.example.notification.notificationService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Ankit Vashistha
 */
@Table(name = "sender_notification_master")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SenderNotificationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private long s_id;

    @Column(name = "s_hostName")
    private String s_hostName;

    @Column(name = "s_portNo")
    private int s_portNo;

    @Column(name = "s_emailAddress")
    private String s_emailAddress;

    @Column(name = "s_emailPassword")
    private String s_emailPassword;

    @Column(name = "s_reciverEmailID")
    private String s_receiverEmailID;
}
