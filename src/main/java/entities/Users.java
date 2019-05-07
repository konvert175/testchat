package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Users {
    @Getter
    @Setter
    @Id
    private int id;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;
    public Users (int id,String login,String password)
    {
        this.id=id;
        this.login=login;
        this.password=password;
    }
}
