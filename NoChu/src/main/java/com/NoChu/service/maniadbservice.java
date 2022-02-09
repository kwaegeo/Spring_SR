package com.NoChu.service;

import com.NoChu.dto.Chart;
import com.NoChu.dto.songinfo;
import com.NoChu.model.ResponseModel.Item;
import com.NoChu.model.ResponseModel.ManiadbResponse;
import com.NoChu.model.ResponseModel.responseArtist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class maniadbservice {

    @Autowired
    private ManiadbResponse maniadbResponse;

//    public List<songinfo> search(String songorartist){
//
//        List<songinfo> a = new ArrayList();
//
//        return a;
//    }


    public ManiadbResponse searchManiadb(String songorartist) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String URI = "http://www.maniadb.com/api/search/"+songorartist+"/?sr=artist&display=10&key=example&v=0.5";

        XmlMapper xmlMapper = (XmlMapper) new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        String returna =  restTemplate.getForObject(URI, String.class);

        //System.out.println(returna);

        maniadbResponse = xmlMapper.readValue(returna, ManiadbResponse.class);

        Item a = maniadbResponse.getChannel().getItem().get(0);
        Item b = maniadbResponse.getChannel().getItem().get(1);

        System.out.println(a.getTitle()+a.getDemographic()+a.getImage());
        System.out.println(b.getTitle()+b.getDemographic()+b.getImage());



        return maniadbResponse;
    }


}
