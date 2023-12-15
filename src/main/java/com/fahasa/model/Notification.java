package com.fahasa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Date notificationDate;

    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "typeNotifyId")
    private TypeNotify typeNotify;

    @JsonBackReference(value = "notification-user")
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
