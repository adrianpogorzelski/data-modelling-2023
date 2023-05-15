package edu.wsb.datamodellingdemo.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
    
    @GetMapping
    String index() {
        return "mail/index";
    }

    
}
