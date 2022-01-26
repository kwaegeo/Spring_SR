package com.NoChu.controller.Api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class crawling {

    //멜론 차트 사이트 주소
    private final String URL ="https://www.melon.com/chart/index.htm";

    private List<String> song;
    //https://www.melon.com/chart/index.htm
    @GetMapping("/crawling")
    public void main() throws IOException {


        //HTML 문서
        Document doc = null;

        //HTML문서의 요소들
        Elements tmp;

        //멜론차트에 연결
        try{
            doc = Jsoup.connect(URL).get();

        }catch(Exception e){

            e.printStackTrace();
        }

        //멜론차트표를 elements에 담고
//*[@id="lst50"]/td[4]/div/a/img
       // #lst50 > td:nth-child(4) > div > a > img
//document.select("#docs > div:eq(1) > h4 > a").attr("href");
        //String aaa = elements.get(0).text();
      //  doc.select("#lst50 > td:nth-child(4) > div > a >img").get(i));
        ArrayList a = new ArrayList();

        for(int i=0; i<10; i++){
            Element elementsz = doc.select("#lst50 > td:nth-child(4) > div > a >img").get(i);
            song.add(elementsz.text());
            System.out.println(song.get(i));
        }

//        String name_temp = null;
//        String singer_temp = null;
//        String album_temp = null;
//        String imgCover_temp = null;
//        int rank = 0;

//        for(int i =0; i<10; i++){
//
//            //노래제목을 tmp에 담고
//            tmp = elements.select("div.ellipsis.rank01");
//            //0번째를 담아준다.
//            name_temp = tmp.get(i).text();
//
//            //가수를 tmp에 담고
//            tmp = elements.select("div.ellipsis.rank02").select("span");
//            //0번째를 담아준다.
//            singer_temp = tmp.get(i).text();
//
//            //앨범
//            tmp = elements.select("div.ellipsis.rank03");
//            //0번째를 담아준다.
//            album_temp = tmp.get(i).text();
//
//            //등수
//            tmp = elements.select("span.rank");
//            //0번째를 담아준다.
//            rank = Integer.parseInt((tmp.get(i).text()));
//
////            tmp = elements.
//
////*[@id="lst50"]/td[4]/div/a/img
//
//
//        }
    }

}
