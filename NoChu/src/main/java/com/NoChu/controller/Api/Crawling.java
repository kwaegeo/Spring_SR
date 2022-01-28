package com.NoChu.controller.Api;

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
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:/chromedriver.exe";


    // 크롤링 할 URL
    private String base_url;

    public int rank;
    public String albumImg;
    public String songName;
    public String artist;

    public List<Chart> 목록(){
        // Driver SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Options Setting
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

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

}
