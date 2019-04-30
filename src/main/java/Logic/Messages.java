package Logic;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
   Класс для пересылки сообщений об ошибках
 */
@Component
public class Messages {
    /** Поле Сообщение */
    private String mes;
    public Messages() {
        Date NowDate = new Date();
        mes = NowDate.toString();
    }
    public String getMes() {
        return mes;
    }

    public void setMes(String
                               mes) {
        this.mes = mes;
    }
}
