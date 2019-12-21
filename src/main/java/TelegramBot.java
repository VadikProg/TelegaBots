import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return "Geniy10AklassaBot";
    }

    public String getBotToken() {
        return "933229353:AAHKPN8Pe2PeIQp8bvmSOPJmpGDr-UMp2YU\n";
    }
}
