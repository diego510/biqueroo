package com.example.biquerito.controllers;

import com.example.biquerito.domain.Notification;
import com.example.biquerito.domain.User;
import com.example.biquerito.repository.NotificationRepository;
import com.example.biquerito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Secured({ "ADMIN", "USER" })
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @Secured({ "ADMIN", "USER" })
    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long notificationId) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);

        if (notificationOptional.isPresent()) {
            return new ResponseEntity<>(notificationOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Secured({ "ADMIN", "USER" })
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        // Verifica si el usuario asociado a la notificación existe en la base de datos
        Optional<User> userOptional = userRepository.findById(notification.getUser().getId());

        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Manejar el error
        }

        // Realiza cualquier otra lógica necesaria antes de guardar la notificación
        Notification newNotification = notificationRepository.save(notification);

        return new ResponseEntity<>(newNotification, HttpStatus.CREATED);
    }

    @Secured({ "ADMIN", "USER" })
    @PutMapping("/{notificationId}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long notificationId,
                                                           @RequestBody Notification updatedNotification) {
        Optional<Notification> existingNotificationOptional = notificationRepository.findById(notificationId);

        if (existingNotificationOptional.isPresent()) {
            Notification existingNotification = existingNotificationOptional.get();

            // Actualiza los campos necesarios
            existingNotification.setContent(updatedNotification.getContent());
            existingNotification.setDatetime(updatedNotification.getDatetime());
            existingNotification.setStatus(updatedNotification.getStatus());

            // Guarda la notificación actualizada
            Notification updatedNotificationEntity = notificationRepository.save(existingNotification);

            return new ResponseEntity<>(updatedNotificationEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Secured({ "ADMIN", "USER" })
    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationId) {
        if (notificationRepository.existsById(notificationId)) {
            notificationRepository.deleteById(notificationId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
