import java.lang.*;
import java.io.*;
import java.math.*;
import java.sql.*;
import java.util.*;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        final String prefix = "/";
        String[] BanWords = {"BanWord", "Nigger", "pshit"};

        String message = update.getMessage().getText();
        int MessageID = update.getMessage().getMessageId();
        String UserID = update.getMessage().getAuthorSignature();
        System.out.println("Сигнатура автора " + UserID); //Я хз, что такое сигнатура, це дебаг

        SendMessage SendMessage = new SendMessage();
        DeleteMessage DelMessage = new DeleteMessage();

        SendMessage.setChatId(update.getMessage().getChatId().toString());
        DelMessage.setChatId(update.getMessage().getChatId().toString());

        if(message.startsWith(prefix)){ //Обработка сообщения с префиксом(prefix)
            message = message.substring(prefix.length(), message.length() - 1);
            String[] PreArguments = message.split(" ");
            String command = PreArguments[0];
            String[] arguments = Arrays.copyOfRange(PreArguments, 1, PreArguments.length - 1);
            if(command.equals("/start")){
                StringBuilder builder = new StringBuilder();
                builder.append("Привет, я админ этого чата\n");
                builder.append("Мои комманды:\n");
                builder.append(" /start\n/BanWords");
                SendMessage.setText(builder.toString());
            }else if(command.equals("/BanWords")){
                SendMessage.setText(update.getMessage().getFrom().getFirstName());
                StringBuilder builder = new StringBuilder();
                builder.append("Запрещенные слова:");
                for(String i : BanWords){
                    builder.append(" ");
                    builder.append(i);
                }
                SendMessage.setText(builder.toString());
            }else{ //Тут еще обработка
                System.out.println("Удаляем неверную комманду");
            }
        }else{ //Сюда заходим если пришло обычное сообщение
            String[] msg = message.split(" ");
            for(String i : BanWords){
                if(message.contains(i)){
                    System.out.println("BanWord " + i);
                    //DelMessage.setMessageId(MessageID);
                }
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
        return "933229353:AAEBUDqQTUIk7auGEt5Su_nlB39s600wnLs";
    }
}