package com.NoChu.model.ResponseModel.ArtistXmlM;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@NoArgsConstructor
@JacksonXmlRootElement(localName = "item")
public class Item {


    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlProperty(localName = "demographic")
    private String demographic;

    @JacksonXmlProperty(localName = "image")
    private String image;

    @JacksonXmlProperty(localName = "period")
    private String period;

    Item(String title, String demographic, String image, String period){
        this.title = title;
        this.image = image;
        this.demographic = demographic;
        this.period = period;
    }

}
