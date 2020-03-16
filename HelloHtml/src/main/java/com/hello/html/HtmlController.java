package com.hello.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
    @RequestMapping
    public String index(Model model){
        model.addAttribute("msg","Hello Html!");
        return "index";
    }
}
