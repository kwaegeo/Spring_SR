package com.NoChu.controller;

import com.NoChu.service.chartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @Autowired
    private chartService chartservice;

    @GetMapping("/")
    public String mainpage(Model model){
        model.addAttribute("Chart", chartservice.국십());

        return "Sample/index2";
    }
}
