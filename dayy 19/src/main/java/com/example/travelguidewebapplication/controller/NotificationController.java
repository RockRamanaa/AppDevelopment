package com.example.travelguidewebapplication.controller;

import com.example.travelguidewebapplication.DTO.response.NotificationResponseDTO;
import com.example.travelguidewebapplication.service.inter.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationResponseDTO>> testNotification() {
        return ResponseEntity.ok(notificationService.newCommentNotification());
    }

    @PostMapping
    public void updateNotificationStatus() {
        notificationService.notificationFalse();
    }
}
