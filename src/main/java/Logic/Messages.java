package Logic;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class Messages {
    private String mes="5555555555555";
    public Messages() {
        System.out.println(Counter.getNum() + " Messages конструктор");
    }
    public String getMes() {
        System.out.println(Counter.getNum()+" Messages getMes");
        mes+="2";
        return mes;
    }

    public void setMes(String mes) {
        System.out.println(Counter.getNum()+" Messages setMes");
        this.mes = mes;
    }
}
