package Logic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    List<ChatUser> persons = new ArrayList<ChatUser>();

    ChatUser CUser = new ChatUser();
    @RequestMapping(value="/welcome", method=RequestMethod.GET)
    public String welcomeForm(Model model) {
        model.addAttribute("chatuser", CUser).addAttribute("mess", new Messages());
        model.addAttribute("persons", persons);
        return "welcome";
    }

    @RequestMapping(value="/welcome", method=RequestMethod.POST)
    public String welcomeSubmit(@ModelAttribute ChatUser CUser,
                                @ModelAttribute Messages mess,
                               // @ModelAttribute List<ChatUser> persons,
                                Model model) {
        model.addAttribute("chatuser", CUser).addAttribute("mess",mess);
        model.addAttribute("persons", persons);
        if (CUser.getMessage()!=null) {
            if (CUser.getMessage().equals(""))
            {
                mess.setMes("Сообщение не может быть пустым");
                return "mesq";
            }
            persons.add(CUser);
        }
        if (CUser.getLogin().equals("")) {
            mess.setMes("Необходимо указать логин");
            return "mesq";
        }
        return "result";
    }

    @RequestMapping(value="/mesq", method=RequestMethod.GET)
    public String mesqForm(Model model) {
        model.addAttribute("mess", new Messages());
        return "mesq";
    }
}