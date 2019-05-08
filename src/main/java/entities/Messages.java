package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Класс для пересылки сообщений об ошибках
 */
public class Messages {
    /**
     * Поле Сообщение
     */
    @Getter
    @Setter
    private String mes;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String sender;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String content;

    public Messages() {
        Date nowDate = new Date();
        mes = nowDate.toString();
    }

    @Override
    public String toString() {
        return " mes: "+mes+"  username: "+username+"  sender: "+sender+"  type: "+type+"  content: "+content;
    }
}
