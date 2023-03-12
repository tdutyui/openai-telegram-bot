package com.example.openaitelegrambot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "chat", url = "http://localhost:8080/chat-api/request")
public interface ChatClient {
    
    @PostMapping
    String createChatCompletion(@RequestBody String request);
}
