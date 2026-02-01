package utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class TelegramUtils {

    // Token del bot y chat ID del admin
    private static final String BOT_TOKEN = "8598100014:AAE_lomHhxtDk_RS5XwKwkdhEMq1LcQYpXY";
    private static final String ADMIN_CHAT_ID = "1462144147";

    public static void enviarMensajeAdmin(String mensaje) {
        try {
            String urlString = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String data = "chat_id=" + ADMIN_CHAT_ID + "&text=" + java.net.URLEncoder.encode(mensaje, "UTF-8");

            try (OutputStream os = conn.getOutputStream()) {
                os.write(data.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error enviando Telegram: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Excepción al enviar mensaje Telegram: " + e.getMessage());
        }
    }
}

