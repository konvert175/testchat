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
        System.out.println(Counter.getNum() + " Messages конструктор "+ mes);
    }
    public String getMes() {
        System.out.println(Counter.getNum()+" Messages getMes");
        return mes;
    }

    public void setMes(String mes) {
        System.out.println(Counter.getNum()+" Messages setMes");
        this.mes = mes;
    }
}
