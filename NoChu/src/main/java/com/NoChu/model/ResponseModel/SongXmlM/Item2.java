package com.NoChu.model.ResponseModel.SongXmlM;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JacksonXmlRootElement(localName = "item")
public class Item2 {


    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlProperty(localName = "description")
    private String description;

    @JacksonXmlProperty(localName = "album")
    private Album album;

    @JacksonXmlProperty(localName = "artist")
    private Artist artist;


    Item2(String title, String description, Album album, Artist artist){
        this.title = title;
        this.description = description;
        this.album = album;
        this.artist = artist;
    }

}
