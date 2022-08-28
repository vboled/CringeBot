package com.keypopsh.cringebot.controllers;

import com.keypopsh.cringebot.bot.CringeBot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebhookController {
    private final CringeBot cringeBot;

    public WebhookController(CringeBot cringeBot) {
        this.cringeBot = cringeBot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return cringeBot.onWebhookUpdateReceived(update);
    }
}