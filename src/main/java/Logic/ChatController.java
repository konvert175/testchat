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
        System.out.println(Counter.getNum()+" welcome get");
        return "welcome";
    }

    @RequestMapping(value="/welcome", method=RequestMethod.POST)
    public String welcomeSubmit(@ModelAttribute ChatUser CUser,
                                @ModelAttribute Messages mess,
                               // @ModelAttribute List<ChatUser> persons,
             Model model) {
        model.addAttribute("chatuser", CUser).addAttribute("mess",mess);
        model.addAttribute("persons", persons);
        persons.add(CUser);
        System.out.println(Counter.getNum()+" welcome post");
        System.out.println(CUser.getLogin()+" "+CUser.getMessage());
        return "result";
    }
    /*
    @RequestMapping(value="/result", method=RequestMethod.GET)
    public String resultForm(Model model) {
        model.addAttribute("chatuser", new ChatUser()).addAttribute("mess", new Messages());
        System.out.println("result get");
        return "result";
    }

    @RequestMapping(value="/result", method=RequestMethod.POST)
    public String resultSubmit(@ModelAttribute ChatUser chatuser,@ModelAttribute Messages mess, Model model) {
        model.addAttribute("chatuser", chatuser).addAttribute("mess",mess);
        System.out.println("result post");
        return "result";
    }
*/
    @RequestMapping(value="/mesq", method=RequestMethod.GET)
    public String mesqForm(Model model) {
        model.addAttribute("mess", new Messages());
        return "mesq";
    }
}