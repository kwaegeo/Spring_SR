package com.NoChu.model.ResponseModel.ArtistXmlM;

import com.NoChu.model.ResponseModel.ArtistXmlM.Channel;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@JacksonXmlRootElement(localName = "rss")
public class ManiadbResponse {

    @JacksonXmlProperty(localName = "channel")
    private Channel channel;

}
