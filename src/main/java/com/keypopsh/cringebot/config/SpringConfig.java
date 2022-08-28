package com.keypopsh.cringebot.config;

import com.keypopsh.cringebot.bot.CringeBot;
import com.keypopsh.cringebot.handlers.MessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class SpringConfig {
    private final CringeBotConfig cringeBotConfig;

    public SpringConfig(CringeBotConfig cringeBotConfig) {
        this.cringeBotConfig = cringeBotConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(cringeBotConfig.getWebhookPath()).build();
    }

    @Bean
    public CringeBot springWebhookBot(SetWebhook setWebhook, MessageHandler messageHandler) {
        CringeBot bot = new CringeBot(setWebhook, messageHandler);

        bot.setWebhookPath(cringeBotConfig.getWebhookPath());
        bot.setBotName(cringeBotConfig.getBotName());
        bot.setBotToken(cringeBotConfig.getBotToken());

        return bot;
    }
}