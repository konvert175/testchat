package controller;

import entities.ChatUser;
import entities.Messages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    List<ChatUser> persons = new ArrayList<>();
    ChatUser cuser = new ChatUser();

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
        model.addAttribute("chatuser", cuser).addAttribute("mess",mess);
        model.addAttribute("persons", persons);
        if ((cuser.getMessage()!=null)&&(!cuser.getMessage().equals(""))) {
                persons.add(cuser);
        }
        if (cuser.getLogin().equals("")) {
            mess.setMes("Необходимо указать логин");
            return "mesq";
        }
        if (cuser.getLogin().contains(" ")) {
            mess.setMes("Логин не может содержать пробелы/состоять из пробелов");
            return "mesq";
        }
        return "result";
    }

    @GetMapping(value="/mesq")
    public String mesqForm(Model model) {
        model.addAttribute("mess", new Messages());
        return "mesq";
    }
}