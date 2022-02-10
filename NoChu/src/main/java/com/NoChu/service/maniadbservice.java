package com.NoChu.service;

import com.NoChu.model.ResponseModel.ArtistXmlM.Item;
import com.NoChu.model.ResponseModel.ArtistXmlM.ManiadbResponse;
import com.NoChu.model.ResponseModel.SongXmlM.Item2;
import com.NoChu.model.ResponseModel.SongXmlM.SongResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class maniadbservice {

    @Autowired
    private ManiadbResponse maniadbResponse;


    @Autowired
    private SongResponse songResponse;
//    public List<songinfo> search(String songorartist){
//
//        List<songinfo> a = new ArrayList();
//
//        return a;
//    }


    public List<Item> 가수검색(String SongOrArtist) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        List<Item> SearchResult;

        String URI = "http://www.maniadb.com/api/search/"+SongOrArtist+"/?sr=artist&display=10&key=example&v=0.5";

        XmlMapper xmlMapper = (XmlMapper) new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        String XmlDec =  restTemplate.getForObject(URI, String.class);

        System.out.println(XmlDec);

        maniadbResponse = xmlMapper.readValue(XmlDec, ManiadbResponse.class);

        Item a = maniadbResponse.getChannel().getItem().get(0);
        //Item b = maniadbResponse.getChannel().getItem().get(1);

        System.out.println(a.getTitle()+a.getDemographic()+a.getImage());
        //System.out.println(b.getTitle()+b.getDemographic()+b.getImage());

        SearchResult = maniadbResponse.getChannel().getItem();


        return SearchResult;
    }

    public List<Item2> 노래검색(String SongOrArtist) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        List<Item2> SearchResult2;

        String URI = "http://www.maniadb.com/api/search/"+SongOrArtist+"/?sr=song&display=10&key=example&v=0.5";

        XmlMapper xmlMapper = (XmlMapper) new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        String XmlDec =  restTemplate.getForObject(URI, String.class);

        System.out.println(XmlDec);

        songResponse = xmlMapper.readValue(XmlDec, SongResponse.class);

        Item2 b = songResponse.getChannel2().getItem2().get(1);
        //Item b = maniadbResponse.getChannel().getItem().get(1);

        //System.out.println(b.getAlbum().getImage());
        //System.out.println(b.getTitle()+b.getDemographic()+b.getImage());

        SearchResult2 = songResponse.getChannel2().getItem2();


        return SearchResult2;
    }






}
