package com.NoChu.controller;

import com.NoChu.service.API_service.Crawling;
import com.NoChu.service.chartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

    @Autowired
    private chartService chartservice;

    @Autowired
    private Crawling crawling;

    @GetMapping("/")
    public String mainpage(Model model){
        model.addAttribute("Kpop", crawling.kpop십곡());
        model.addAttribute("pop",crawling.pop십곡());
        return "Sample/index2";
    }

    @GetMapping("/test23")
    public String testt(){
        return "Sample/musicdetail";
    }
}
