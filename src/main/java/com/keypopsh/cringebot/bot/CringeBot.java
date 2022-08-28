package com.keypopsh.cringebot.bot;
import com.keypopsh.cringebot.handlers.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;


public class CringeBot extends SpringWebhookBot {
    private final Logger logger = LoggerFactory.getLogger(CringeBot.class);

    private String botName;
    private String botToken;
    private String webhookPath;

    MessageHandler messageHandler;

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public void setWebhookPath(String webhookPath) {
        this.webhookPath = webhookPath;
    }

    public CringeBot(SetWebhook setWebhook, MessageHandler messageHandler) {
        super(setWebhook);
        this.messageHandler = messageHandler;
        logger.info("CringeBot constructor:\n messageHandler: {}\n",
                this.messageHandler.toString());
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        try {
            return handleUpdate(update);
        } catch (IllegalArgumentException e) {
            return new SendMessage(update.getMessage().getChatId().toString(),
                    "IllegalArgumentException");
        } catch (Exception e) {
            return new SendMessage(update.getMessage().getChatId().toString(),
                    "Exception");
        }
    }

    @Override
    public String getBotPath() {
        return null;
    }

    private BotApiMethod<?> handleUpdate(Update update) {
        Message message = update.getMessage();
        if (message != null) {
            logger.debug("message: {}", message.toString());
            return messageHandler.answerMessage(update.getMessage());
        }
        logger.warn("message is null!");
        return null;
    }
}
