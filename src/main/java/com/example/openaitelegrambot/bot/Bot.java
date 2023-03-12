package com.example.openaitelegrambot.bot;

import com.example.openaitelegrambot.client.ChatClient;
import com.example.openaitelegrambot.client.ImageClient;
import com.example.openaitelegrambot.exception.MessageSendException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {
    
    private boolean isChat = true;
    private final ChatClient chatClient;
    private final ImageClient imageClient;
    
    private static final String TOKEN = System.getenv("BOT_TOKEN");
    private static final String USERNAME = System.getenv("BOT_USERNAME");
    
    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        Long userId = update.getMessage().getFrom().getId();
        if (message.equals("/image")) {
            sendText(userId, "Send text to generate image");
            isChat = false;
            return;
        }
        if (message.equals("/chat")) {
            sendText(userId, "Let's chat!");
            isChat = true;
        } else if (isChat) {
            sendText(userId, chatClient.createChatCompletion(message));
        } else {
            sendText(userId, imageClient.createImage(message));
        }
    }
    
    @Override
    public String getBotUsername() {
        return USERNAME;
    }
    
    @Override
    public String getBotToken(){
        return TOKEN;
    }
    
    private void sendText(Long userId, String text) {
        SendMessage sm = SendMessage.builder()
                .chatId(userId.toString())
                .text(text).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new MessageSendException(e.getMessage());
        }
    }
}
