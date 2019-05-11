package logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


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
        SpringApplication.run(Application.class,args);
    }



}