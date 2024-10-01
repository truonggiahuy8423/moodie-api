package com.example.moodie.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MoodieController {
    @MessageMapping("/message")
    @SendTo("/topic/messages/123")
    public String sendMessage(String message) {
        return "Received: " + message;
    }
}
