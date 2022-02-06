package com.NoChu.model.ResponseModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@JacksonXmlRootElement(localName="rss")
@Component
public class ManiadbResponse {

    @JacksonXmlProperty(localName = "channel")
    private responseArtist responseArtist;

}
