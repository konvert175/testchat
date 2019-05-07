package logic;

import config.AppConfiguration;
import entities.ChatUserDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;

import java.util.List;

@ComponentScan("logic,entities,controller,config")
@EnableAutoConfiguration
public class Application {
/*
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[]{
                AppConfiguration.class
        };
    }*/
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("))((");

/*
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ChatUserDAOImpl dao = context.getBean(ChatUserDAOImpl.class);

        List<String> names = dao.getUserlogins();

        for (String name : names) {

            System.out.println("Dept Name: " + name);
        }

 */
    }



}