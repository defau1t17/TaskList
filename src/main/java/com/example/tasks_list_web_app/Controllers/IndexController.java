package com.example.tasks_list_web_app.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String mainRedirect() {
        return "redirect:/tasks/addToList";
    }
}
