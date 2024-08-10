package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    private final List<String> messages = new ArrayList<>();

    @GetMapping("/hello")
    public ResponseEntity<Object> sayHello() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "Hello, Spring Boot With Docker!");
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping("/messages")
    public ResponseEntity<Object> getMessages() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", messages);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @PostMapping(value="/messages", consumes="application/json")
    public ResponseEntity<Object> addMessage(@RequestBody Map<String, String> message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "Message Added: " + message);
        messages.add(message.getOrDefault("message", "DEFAULT"));
        return ResponseEntity
                .ok()
                .body(response);
    }

    @PutMapping("/messages/{index}")
    public ResponseEntity<Object> updateMessage(@PathVariable int index, @RequestBody String updatedMessage) {
        String message = "";
        if (index < messages.size()) {
            messages.set(index, updatedMessage);
            message = "Message updated at index " + index + ": " + updatedMessage;
        } else {
            message = "Invalid index";
        }
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", message);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @DeleteMapping("/messages/{index}")
    public ResponseEntity<Object> deleteMessage(@PathVariable int index) {
        String message = "";
        if (index < messages.size()) {
            String removedMessage = messages.remove(index);
            message = "Message removed at index " + index + ": " + removedMessage;
        } else {
            message = "Invalid index";
        }
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", message);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @DeleteMapping("/messages")
    public ResponseEntity<Object> deleteAllMessages() {
        messages.clear();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "All messages deleted");
        return ResponseEntity
                .ok()
                .body(response);
    }
}
