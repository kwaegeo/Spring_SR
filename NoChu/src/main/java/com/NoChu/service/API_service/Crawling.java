package com.NoChu.service.API_service;

import com.NoChu.dto.Chart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private String videourl;


    private WebDriver setup(){
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
        driver.quit();
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
        driver.quit();
        return chartList;
    }


    public String 노래듣기(String SongName, String Artist){

        driver = setup();

        //주소설정
        base_url = "https://www.youtube.com/results?search_query="+SongName+Artist;
        //연결
        driver.get(base_url);

        System.out.println("유튜브접속");
        try{
                System.out.println(SongName +" "+Artist);
                //검색 필드 탐색

//                driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/button")).click();
//                System.out.println("검색 버튼 클릭");

                driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
                //driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[25]/div[2]/div[1]/button")).click();
                //driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[8]/div[2]/ytd-video-primary-info-renderer/div/div/div[3]/div/ytd-menu-renderer/div/ytd-button-renderer[1]/a/yt-formatted-string")).click();

                Thread.sleep(500);

                driver.findElement(By.cssSelector("body")).sendKeys(Keys.SPACE);

                //webElement = driver.findElement(By.xpath("/html/head/meta[20]"));
            //String url = driver.getCurrentUrl();


                System.out.println("여까지와");
                String orivideourl = driver.getCurrentUrl();
                String vide = orivideourl.substring(32);                //https://www.youtube.com/watch?v=FCrMKhrFH7A
                videourl = "https://www.youtube.com/embed/"+vide;

                System.out.println(videourl);

//*[@id="wpc-c4f60648-0946-4d2e-a889-c3082192c6f6"]/div[1]/div/div[1]/video

           // head > link:nth-child(43)


        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
        return videourl;
    }

}
