package com.NoChu.model.ResponseModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
public class responseArtist {

    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlProperty(localName = "reference")
    private String reference;

    @JacksonXmlProperty(localName = "demographic")
    private String demographic;

    @JacksonXmlProperty(localName = "period")
    private String period;

    @JacksonXmlProperty(localName = "link")
    private String link;

    @JacksonXmlProperty(localName = "image")
    private String image;

    @JacksonXmlProperty(localName = "description")
    private String description;

}
