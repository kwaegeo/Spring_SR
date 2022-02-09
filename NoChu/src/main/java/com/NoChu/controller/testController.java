package com.NoChu.controller;

import com.NoChu.model.ResponseModel.ManiadbResponse;
import com.NoChu.model.ResponseModel.responseArtist;
import com.NoChu.service.maniadbservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {

    @Autowired
    private maniadbservice maniadbservice;

    @Autowired
    private ManiadbResponse maniadbResponse;

    @GetMapping("/test24")
    public String ad() throws JsonProcessingException {
        String a = "비오";

        maniadbResponse= maniadbservice.searchManiadb(a);

//        System.out.println(maniadbResponse.getManiadbData().getResponseArtist());

        return a;
    }
}


