package com.keypopsh.cringebot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageHandler {

    public BotApiMethod<?> answerMessage(Message message) {
        String chatId = message.getChatId().toString();

        String inputText = message.getText();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (inputText == null) {
            throw new IllegalArgumentException();
        } else if (inputText.startsWith("/")) {
            SendMessage sendMessage = new SendMessage(chatId, "Command");
            sendMessage.enableMarkdown(true);
            return sendMessage;
        } else {
            SendMessage sendMessage = new SendMessage(chatId, "Non Command");
            sendMessage.enableMarkdown(true);
            return sendMessage;
        }
    }
}
