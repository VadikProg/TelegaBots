import java.lang.*;
import java.io.*;
import java.math.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        String message = update.getMessage().getText();
        SendMessage SendMessage = new SendMessage();
        SendMessage.setChatId(update.getMessage().getChatId().toString());

        if(message.equals("/start")){
            SendMessage.setText("Привет, я админ этого чата");
        }else if(message.equals("/BanWords")){
            SendMessage.setText(update.getMessage().getFrom().getFirstName());
            SendMessage.setText("Пидор; Нигга; Хач;");
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
