package com.NoChu.model.ResponseModel;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ManiaDbTrackData {
    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlProperty(localName = "album")
    private ManiaDbAlbumData albumData;

    @JacksonXmlProperty(localName = "artist")
    private ManiaDbArtistData artistData;

    ManiaDbTrackData(String title, ManiaDbAlbumData albumData, ManiaDbArtistData artistData) {
        this.title = title;
        this.albumData = albumData;
        this.artistData = artistData;
    }
}
