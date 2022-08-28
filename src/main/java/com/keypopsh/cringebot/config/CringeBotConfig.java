package com.keypopsh.cringebot.config;

import com.keypopsh.cringebot.bot.CringeBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "cringe-bot")
@ConstructorBinding
public class CringeBotConfig {
    private final Logger logger = LoggerFactory.getLogger(CringeBotConfig.class);

    private final String botName;
    private final String botToken;
    private final String webhookPath;

    public CringeBotConfig(String botName, String botToken, String webhookPath) {
        this.botName = botName;
        this.botToken = botToken;
        this.webhookPath = webhookPath;
        logger.info("Config is loaded! BotName: {}; WebhookPath: {}", botName, webhookPath);
    }

    public String getBotName() {
        return botName;
    }

    public String getBotToken() {
        return botToken;
    }

    public String getWebhookPath() {
        return webhookPath;
    }
}
