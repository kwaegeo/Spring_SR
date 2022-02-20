package com.NoChu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

    @GetMapping("/login")
    public String login(){


        return "user/loginform";
    }
}
