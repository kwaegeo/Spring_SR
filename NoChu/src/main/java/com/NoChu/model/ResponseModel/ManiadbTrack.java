package com.NoChu.model.ResponseModel;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ManiadbTrack {

    private final String title;
    private final String artist;
    private final String imageUrl;

    @Builder
    private ManiadbTrack(String title, String artist, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
    }

    public static ManiadbTrack from(ManiaDbTrackData trackData) {
        ManiaDbArtistData artistData = trackData.getArtistData();
        ManiaDbAlbumData albumData = trackData.getAlbumData();

        return ManiadbTrack.builder()
                .title(trackData.getTitle())
                .artist(artistData.getName())
                .imageUrl(albumData.getImageUrl())
                .build();
    }
}
