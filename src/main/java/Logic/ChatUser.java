package Logic;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ChatUser {
    private String login;
    private String message;
    private String datetime;
    public ChatUser(String login,String message)
    {
        this.login=login;
        this.message=message;
        datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public ChatUser(){
        datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    };
    @Bean
    public String getLogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }
    @Bean
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
