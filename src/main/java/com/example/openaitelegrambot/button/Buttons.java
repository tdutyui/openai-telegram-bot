package com.example.openaitelegrambot.button;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@Component
public class Buttons {
    
    private Buttons(){
    
    }
    
    private static final KeyboardButton CHAT = new KeyboardButton("ChatGPT");
    private static final KeyboardButton IMAGE = new KeyboardButton("DALL-E");
    
    public static ReplyKeyboardMarkup replyKeyboardMarkup() {
        List<KeyboardButton> buttons = List.of(CHAT, IMAGE);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(List.of(new KeyboardRow(buttons)));
        replyKeyboardMarkup.setResizeKeyboard(Boolean.TRUE);
        return replyKeyboardMarkup;
    }
}
