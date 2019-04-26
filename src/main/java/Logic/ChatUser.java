package Logic;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChatUser {
    private String login;
    private String message="Привет";
    public ChatUser(String login,String message)
    {
        this.login=login;
        this.message=message;
        System.out.println(Counter.getNum()+" ChatUser конструктор c параметрами");
    }
    public ChatUser(){
        System.out.println(Counter.getNum()+" ChatUser конструктор");
    };
    @Bean
    public String getLogin() {
        System.out.println(Counter.getNum()+" ChatUser getLogin");
        return login;
    }

    public void setlogin(String login) {
        System.out.println(Counter.getNum()+" ChatUser setLogin");
        this.login = login;
    }
    @Bean
    public String getMessage() {
        System.out.println(Counter.getNum()+" ChatUser getMessage");
        return message;
    }

    public void setMessage(String message) {
        System.out.println(Counter.getNum()+" ChatUser setmessage");
        this.message = message;
    }
}
