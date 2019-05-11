package entities;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс для пересылки сообщений по Websocket
 */
public class Messages {
    private static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    /**
     * Поле Сообщение
     */
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String datatime;
    @Getter
    @Setter
    private String username;
    public Messages() {
        datatime = new SimpleDateFormat(DATE_FORMAT).format(new Date());
       // message = new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    @Override
    public String toString() {
        return " mes: "+message+"  username: "+username;
    }
}
