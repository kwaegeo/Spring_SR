package com.NoChu.model.ResponseModel.SongXmlM;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@JacksonXmlRootElement(localName = "rss")
public class SongResponse {

    @JacksonXmlProperty(localName = "channel")
    private Channel2 channel2;

}
