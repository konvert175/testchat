package entities;


import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Класс для хранения инфы пользователь-сообщения
 */
public class ChatUser {
    private static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String datetime;

    public ChatUser(String login, String message) {
        this();
        this.login = login;
        this.message = message;
    }

    public ChatUser() {
        datetime = new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }
}
