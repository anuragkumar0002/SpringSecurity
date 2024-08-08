package com.SpringEx.Security.Controller;

import com.SpringEx.Security.Entity.User;
import com.SpringEx.Security.Service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    public UserService userService;

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model){
        Integer id = userService.saveUser(user);
        String message = "User "+id+ "Register";
        model.addAttribute("message", message);
        return "UserRegister";
    }

    @GetMapping("/register")
    public String saveUser(){
        return "UserRegister";
    }



}
