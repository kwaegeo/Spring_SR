package com.NoChu.model.ResponseModel.SongXmlM;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "maniadb:album")
public class Album {

    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlProperty(localName = "image")
    private String image;

    Album(String title, String image){
        this.title = title;
        this.image = image;
    }

}
