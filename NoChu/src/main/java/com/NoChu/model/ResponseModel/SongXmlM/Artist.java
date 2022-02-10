package com.NoChu.model.ResponseModel.SongXmlM;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JacksonXmlRootElement(localName = "maniadb:artist")
public class Artist {

    @JacksonXmlProperty(localName = "name")
    private String name;

}
