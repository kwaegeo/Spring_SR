package com.NoChu.controller;

import com.NoChu.service.API_service.Crawling;
import com.NoChu.service.chartService;
import com.NoChu.service.maniadbservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/music/{SongName}/{Artist}")
    public String MusicVideoSearch(Model model, @PathVariable String SongName, @PathVariable String Artist){
        model.addAttribute("videourl",crawling.노래듣기(SongName, Artist));
        return "/Sample/musicdetail";
    }

    @GetMapping("/search")
    public String SearchArtist(Model model, @RequestParam("SearchQuery") String SongOrArtist) throws JsonProcessingException {
        model.addAttribute("ResultList", maniadbservice.가수검색(SongOrArtist));
        return "/Sample/Artistsearch";
    }

    @GetMapping("/Songsearch")
    public String SearchSong(Model model, @RequestParam("SearchQuery") String SongOrArtist) throws JsonProcessingException {
        model.addAttribute("ResultList",maniadbservice.노래검색(SongOrArtist));
        return "Sample/Songsearch";


    }
}
