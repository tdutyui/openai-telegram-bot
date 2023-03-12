package com.example.openaitelegrambot.exception;

public class MessageSendException extends RuntimeException {
    
    public MessageSendException(String message) {
        super(message);
    }
}
