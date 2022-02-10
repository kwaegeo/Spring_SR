package com.NoChu.controller;

import com.NoChu.model.ResponseModel.ArtistXmlM.Item;
import com.NoChu.model.ResponseModel.ArtistXmlM.ManiadbResponse;
import com.NoChu.model.ResponseModel.SongXmlM.Item2;
import com.NoChu.model.ResponseModel.SongXmlM.SongResponse;
import com.NoChu.service.maniadbservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class testController {

    @Autowired
    private maniadbservice maniadbservice;

    @Autowired
    private ManiadbResponse maniadbResponse;

    @GetMapping("/test23")
    public String testt(){
        return "Sample/musicdetail";
    }

    @GetMapping("/test24")
    public String ad() throws JsonProcessingException {
        String a = "제자리걸음";

        List<Item2> b;
        b = maniadbservice.노래검색(a);


        return b.get(0).getAlbum().getImage();
    }


}


