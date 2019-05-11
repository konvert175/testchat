package controller;

import entities.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    List<ChatUser> persons = new ArrayList<>();
    ChatUser cuser = new ChatUser();
    {
        persons.add(new ChatUser("",""));
        persons.get(0).setDatetime("Сообщения");
    }


    @GetMapping(value="/welcome")
    public String welcomeForm(Model model) {
        model.addAttribute("chatuser", cuser).addAttribute("mess", new Messages());
        model.addAttribute("persons", persons);
        return "welcome";
    }

    @PostMapping(value="/welcome")
    public String welcomeSubmit(@ModelAttribute ChatUser cuser,
                                @ModelAttribute Messages mess,
                               // @ModelAttribute List<ChatUser> persons,
                                Model model) {
        System.out.println("welcomeSubmit");
        model.addAttribute("chatuser", cuser).addAttribute("mess",mess);
        model.addAttribute("persons", persons);
        if ((cuser.getMessage()!=null)&&(!cuser.getMessage().equals(""))) {
                persons.add(cuser);
        }
        if (cuser.getLogin().equals("")) {
            mess.setMessage("Необходимо указать логин");
            return "mesq";
        }
        if (cuser.getLogin().contains(" ")) {
            mess.setMessage("Логин не может содержать пробелы/состоять из пробелов");
            return "mesq";
        }
        return "welcome";
    }

    @GetMapping(value="/mesq")
    public String mesqForm(Model model) {
        model.addAttribute("mess", new Messages());
        return "mesq";
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Messages sendMessage(@Payload Messages chatMessage) {
        persons.add(new ChatUser(chatMessage.getUsername(),chatMessage.getMessage()));
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Messages addUser(@Payload Messages chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getUsername());
        return null;
    }

}