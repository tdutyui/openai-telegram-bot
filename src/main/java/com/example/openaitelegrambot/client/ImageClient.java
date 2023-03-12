package com.example.openaitelegrambot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "image", url = "http://localhost:8081/image-api/create")
public interface ImageClient {
    
    @PostMapping
    String createImage(@RequestBody String request);
}
