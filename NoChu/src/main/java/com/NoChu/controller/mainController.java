package com.NoChu.controller;

import com.NoChu.service.API_service.Crawling;
import com.NoChu.service.chartService;
import com.NoChu.service.maniadbservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class mainController {

    @Autowired
    private chartService chartservice;

    @Autowired
    private maniadbservice maniadbservice;

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

    @GetMapping("/music/{SongName}/{Artist}")
    public String searchmusic(Model model, @PathVariable String SongName, @PathVariable String Artist){
        model.addAttribute("videourl",crawling.노래듣기(SongName, Artist));
        return "/Sample/musicdetail";
    }

//    @GetMapping("/search")
//    public String songsearch(Model model, @PathVariable String songorartist){
//        model.addAttribute(maniadbservice.search(songorartist));
//        return "/Sample/songsearch";
//    }


}
