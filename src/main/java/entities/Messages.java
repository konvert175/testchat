package entities;

import java.util.Date;

/**
 * Класс для пересылки сообщений об ошибках
 */
public class Messages {
    /**
     * Поле Сообщение
     */
    private String mes;

    public Messages() {
        Date nowDate = new Date();
        mes = nowDate.toString();
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
