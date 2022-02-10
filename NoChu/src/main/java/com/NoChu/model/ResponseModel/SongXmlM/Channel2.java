package com.NoChu.model.ResponseModel.SongXmlM;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "channel")
public class Channel2 {

    @JacksonXmlProperty(localName="title")
    private String title;

//    private String description;
//
//    private String lastBuildDate;
//
//    private String total;
//
//    private String start;
//
//    private String display;
//
//    private String maniadburlbase;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName="item")
    private List<Item2> item2 = new ArrayList<>();

}
