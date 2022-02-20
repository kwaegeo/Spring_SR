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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/music2")
    public String MusicVideoSearchSongName(Model model, @RequestParam("songinfo") String songinfo){

        //input type의 값이 직접 정한 value값이 아닌 hidden과 같이 안에 있는 값은
        //th:name으로 매핑을 해준 다음에 받아야한다.

        System.out.println(songinfo);

        model.addAttribute("videourl",crawling.노래듣기(songinfo));
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

    @GetMapping("/test3")
    public String testest(){
        return "Sample/GenreRecomm";
    }
}
