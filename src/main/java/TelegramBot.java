import java.lang.*;
import java.io.*;
import java.math.*;
import java.sql.Array;
import java.util.Arrays;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        final String prefix = "/";
        String message = update.getMessage().getText();
        SendMessage SendMessage = new SendMessage();
        SendMessage.setChatId(update.getMessage().getChatId().toString());

        if(message.startsWith(prefix)){
            message = message.substring(prefix.length(), message.length() - 1);
            String[] Prearguments = message.split(" ");
            String command = Prearguments[0];
            String[] arguments = Arrays.copyOfRange(Prearguments, 1, Prearguments.length - 1);
            if(command.equals("/start")){
                SendMessage.setText("Привет, я админ этого чата");
            }else if(command.equals("/BanWords")){
                SendMessage.setText(update.getMessage().getFrom().getFirstName());
                SendMessage.setText("Пидор; Нигга; Хач;");
            }
        }
        
        try {
            execute(SendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "Geniy10AklassaBot";
    }

    public String getBotToken() {
        return "933229353:AAHKPN8Pe2PeIQp8bvmSOPJmpGDr-UMp2YU";
    }
}