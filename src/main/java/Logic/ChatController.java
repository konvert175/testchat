package Logic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

    @RequestMapping(value="/welcome", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("chatuser", new ChatUser());
        return "welcome";
    }

    @RequestMapping(value="/welcome", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute ChatUser chatuser, Model model) {
        model.addAttribute("chatuser", chatuser);

        return "result";
    }
    @RequestMapping(value="/result", method=RequestMethod.GET)
    public String resultForm(Model model) {
        model.addAttribute("chatuser", new ChatUser());
        return "result";
    }

    @RequestMapping(value="/result", method=RequestMethod.POST)
    public String resultSubmit(@ModelAttribute ChatUser chatuser, Model model) {
        model.addAttribute("chatuser", chatuser);

        return "result";
    }

}