package com.NoChu.service.API_service;

import com.NoChu.dto.Chart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Crawling {

    // WebDriver 에 필요한 멤버변수
    private WebDriver driver;
    private WebElement webElement;

    // Properties
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = "D:/chromedriver.exe";


    // 크롤링 할 URL
    private String base_url;

    private int rank;
    private String albumImg;
    private String songName;
    private String artist;



    public WebDriver setup(){
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Options Setting
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        return driver;
    }


    public List<Chart> kpop십곡(){

        driver = setup();

        //주소설정
        base_url = "https://www.melon.com/chart/";
        //연결
        driver.get(base_url);

        List<Chart> chartList = new ArrayList<>();

        System.out.println("멜론접속");
        try{

            for(int i =1; i<=10; i++){
                //랭킹
                rank = i;

                //앨범커버
                webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr["+i+"]/td[4]/div/a/img"));
                albumImg = webElement.getAttribute("src");
                System.out.println(rank);

                //노래제목
                webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr["+i+"]/td[6]/div/div/div[1]/span/a"));
                songName = webElement.getText();

                //가수 이름
                webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[3]/form/div/table/tbody/tr["+i+"]/td[6]/div/div/div[2]/a"));
                artist= webElement.getText();
                System.out.println("가수");
                System.out.println(albumImg);
                System.out.println(artist);
                System.out.println(songName);

                Chart chart1 = Chart.builder()
                        .Rank(rank)
                        .AlbumImg(albumImg)
                        .SongName(songName)
                        .Artist(artist)
                        .build();

                System.out.println(chart1);

                chartList.add(chart1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return chartList;
    }

    public List<Chart> pop십곡(){

        driver = setup();

        //주소설정
        base_url = "https://www.melon.com/genre/song_list.htm?gnrCode=GN0900#params%5BgnrCode%5D=GN0900&params%5BdtlGnrCode%5D=GN0901&params%5BorderBy%5D=POP&params%5BsteadyYn%5D=N&po=pageObj&startIndex=1";
        //연결
        driver.get(base_url);

        List<Chart> chartList = new ArrayList<>();

        System.out.println("ㅖㅐㅖ 접속");
        try{

            for(int i=1; i<=10; i++){
                //랭킹
                rank = i;

                //앨범커버
                webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr["+i+"]/td[3]/div/a/img"));
                albumImg = webElement.getAttribute("src");
                System.out.println(rank);
                                                          //  /html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr[1]/td[3]/div/a/img
                                                          //  /html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr[2]/td[3]/div/a/img
                //노래제목
                webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr["+i+"]/td[5]/div/div/div[1]/span/a"));
                songName = webElement.getText();
                       // /html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr[1]/td[5]/div/div/div[1]/span/a
                       // /html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr[2]/td[5]/div/div/div[1]/span/a
                //가수 이름
                webElement = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr["+i+"]/td[5]/div/div/div[2]/a"));
                artist= webElement.getText();

//                         /html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr[1]/td[5]/div/div/div[2]/a[1]
//                        /html/body/div/div[3]/div/div/div[7]/form/div/table/tbody/tr[2]/td[5]/div/div/div[2]/a
                System.out.println("가수");
                System.out.println(albumImg);
                System.out.println(artist);
                System.out.println(songName);

                Chart chart1 = Chart.builder()
                        .Rank(rank)
                        .AlbumImg(albumImg)
                        .SongName(songName)
                        .Artist(artist)
                        .build();

                System.out.println(chart1);

                chartList.add(chart1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return chartList;
    }






}
