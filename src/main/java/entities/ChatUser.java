package entities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatUser {
    private String login;
    private String message;
    private String datetime;
    private static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    public ChatUser(String login, String message) {
        this.login = login;
        this.message = message;
        datetime = new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    public ChatUser() {
        datetime = new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }


    public String getLogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

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
