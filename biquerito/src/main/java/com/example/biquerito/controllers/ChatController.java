package com.example.biquerito.controllers;

import org.springframework.security.access.annotation.Secured;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biquerito.domain.Chat;
import com.example.biquerito.repository.ChatRepository;

import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    @Secured("ADMIN")
    @GetMapping()
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = chatRepository.findAll();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }

}
