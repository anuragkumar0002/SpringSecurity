package com.SpringEx.Security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/home", "/"})
    public String showHome(){
        return "home";
    }

    @GetMapping("/admin")
    public String showAdmin(){
        return "admin";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/customer")
    public String customer(){
        return "customer";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
